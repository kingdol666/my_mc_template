package com.kingdol.mymoddemo.gui.screen;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.font.MultilineText;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.tooltip.Tooltip;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

@Environment(EnvType.CLIENT)
public class TutorialScreen extends Screen {
//    private final Screen parent;
    public TutorialScreen() {
        // 此参数为屏幕的标题，进入屏幕中，复述功能会复述。
        super(Text.literal("我的教程屏幕"));
//        this.parent = parent;
    }


    public ButtonWidget button1;
    public ButtonWidget button2;

    @Override
    protected void init() {
        button1 = ButtonWidget.builder(Text.literal("Close Button"), button -> {
                    System.out.println("你点击了按钮 1！");
                    if (this.client != null && this.client.currentScreen != null) {
                        this.client.currentScreen.close();
                    }
                })
                .dimensions(width / 2 - 205, 20, 200, 20)
                .tooltip(Tooltip.of(Text.literal("按钮 1 的提示")))
                .build();
        button2 = ButtonWidget.builder(Text.literal("按钮 2"), button -> {
                    System.out.println("你点击了按钮 2！");
                    this.client.setScreen(new AdditonScreen(this));
                })
                .dimensions(width / 2 + 5, 20, 200, 20)
                .tooltip(Tooltip.of(Text.literal("按钮 2 的提示")))
                .build();

        addDrawableChild(button1);
        addDrawableChild(button2);
    }


    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
        context.drawCenteredTextWithShadow(textRenderer, Text.literal("你必须看到我"), width / 2, height / 2, 0xffffff);
    }
}