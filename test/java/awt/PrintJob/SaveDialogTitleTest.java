/*
 * Copyright 2007 Sun Microsystems, Inc.  All Rights Reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Sun Microsystems, Inc., 4150 Network Circle, Santa Clara,
 * CA 95054 USA or visit www.sun.com if you need additional information or
 * have any questions.
 */

/*
 * @test
 * @bug 4851363
 * @summary Tests the save to file dialog has a title
 * @run main/manual=yesno/othervm SaveDialogTitleTest
 */

import java.awt.*;

public class SaveDialogTitleTest {

    public static void main(String args[]) {

        System.out.print("Once the dialog appears, press OK and the ");
        System.out.print("Save to File dialog should appear and it ");
        System.out.println("must have a window title else the test fails.");
        Toolkit tk = Toolkit.getDefaultToolkit();
        JobAttributes jobAttributes = new JobAttributes();
        jobAttributes.setDestination(JobAttributes.DestinationType.FILE);
        PrintJob printJob =
            tk.getPrintJob(new Frame(), "Save Title Test",
                           jobAttributes, null);
        if (printJob != null) { // in case user cancels.
          printJob.end();
        }
        System.exit(0); // safe because use 'othervm'
    }
}
