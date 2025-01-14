package com.tacz.guns.api.util;

import org.luaj.vm2.LuaFunction;
import org.luaj.vm2.LuaValue;

import com.tacz.guns.util.CycleTaskHelper;

import net.minecraft.world.phys.Vec3;

public class LuaScriptAPI {
	public static String MARKER = "ScriptAPI";

	public Vec3 newVec3(float x, float y, float z){
		return new Vec3(x, y, z);
	}

	/**
     * 委托延迟的循环任务，在主线程执行，是线程安全的，但是时间不是严格的，粒度取决于 TPS。
     *
     * @param value    应当是一个返回 boolean 的 LuaFunction。如果返回 false ，则将退出循环。
     * @param delayMs  延迟执行的时间。
     * @param periodMs 循环执行的间隔。
     * @param cycles   最大循环次数。-1 代表无限次。
     */
    public void safeAsyncTask(LuaValue value, long delayMs, long periodMs, int cycles) {
        LuaFunction func = value.checkfunction();
        CycleTaskHelper.addCycleTask(() -> func.call().checkboolean(), delayMs, periodMs, cycles);
    }

    /**
     * 获取当前系统时间，单位毫秒。
     *
     * @return 当前系统时间
     */
    public long getCurrentTimestamp() {
        return System.currentTimeMillis();
    }
}