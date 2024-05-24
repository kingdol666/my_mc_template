package com.kingdol.mymoddemo.gui.screen;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.tooltip.Tooltip;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

public class AdditonScreen extends Screen {
    private final Screen parent;

    protected AdditonScreen(TutorialScreen tutorialScreen) {
        super(Text.literal("我的教程屏幕二"));
        this.parent = tutorialScreen;
    }
    @Override
    public void close() {
        if (this.client != null) {
            this.client.setScreen(this.parent);
        }
    }
    ButtonWidget button1;

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
        context.drawCenteredTextWithShadow(textRenderer, Text.literal("你必须看到我2!!"), width / 2, height / 2, 0xffffff);
    }

    @Override
    protected void init() {
        super.init();
        button1 = ButtonWidget.builder(Text.literal("Close Button"), button -> {
                    System.out.println("你点击了按钮 1！");
                    if (this.client != null && this.client.currentScreen != null) {
                        this.client.currentScreen.close();
                    }
                })
                .dimensions(width / 2 - 205, 20, 200, 20)
                .tooltip(Tooltip.of(Text.literal("按钮 1 的提示")))
                .build();
        addDrawableChild(button1);
    }
}
