package com.kingdol.mymoddemo.event;

import com.kingdol.mymoddemo.event.test.ClickEventBond;

public class RegisterEvent {
    public static void registerEvents()
    {
        DropEvent.Init();
        ClickEventBond.registerEvents();
    }
}
