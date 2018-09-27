package com.fast.programming.service.designpatterns.command;

import com.fast.programming.service.FeatureBase;

/**
 * @author bowen.yan
 * @since 2016-09-15
 */
public class Command extends FeatureBase {
    @Override
    protected void runOld() {
    }

    @Override
    protected void runNew() {
      /*  Macro macro = new Macro();
        Editor editor = new EditorImpl();
        macro.record(() -> new Open(editor));
        macro.record(() -> new Save(editor));
        macro.record(() -> new Close(editor));
    */

      /*
        Macro macro = new Macro();
        Editor editor = new EditorImpl();
        macro.record(() -> editor.open());
        macro.record(() -> editor.save());
        macro.record(() -> editor.close());
*/

        Macro macro = new Macro();
        Editor editor = new EditorImpl();
        macro.record(editor::open);
        macro.record(editor::save);
        macro.record(editor::close);

        macro.run();

    }
}
