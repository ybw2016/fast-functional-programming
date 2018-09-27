package com.fast.programming.service.designpatterns.command;

/**
 * @author bowen.yan
 * @since 2016-09-17
 */
public class Open implements Action {
    private Editor editor;

    public Open(Editor editor) {
        this.editor = editor;
    }

    @Override
    public void execute() {
        editor.open();
    }
}
