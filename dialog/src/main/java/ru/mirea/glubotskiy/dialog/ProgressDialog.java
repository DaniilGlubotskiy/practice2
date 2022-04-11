package ru.mirea.glubotskiy.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.widget.TextView;

public class ProgressDialog {
    Context context;
    Dialog dialog;

    public ProgressDialog(Context context) {this.context = context;}

    public void ShowDialog(String title) {
        dialog = new Dialog(context);
        dialog.setContentView(R.layout.dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        TextView titleTextView = dialog.findViewById(R.id.textView2);
        titleTextView.setText(title);
        dialog.create();
        dialog.show();
    }
}
