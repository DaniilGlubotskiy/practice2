package ru.mirea.glubotskiy.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class AlertDialogFragment extends DialogFragment {
    public Dialog onCreateDialog(@Nullable Bundle saveInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Здравствуй МИРЭА!")
                .setMessage("Успех близок?")
                .setIcon(R.mipmap.ic_launcher_round)
                .setPositiveButton("Иду дальше", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        ((MainActivity)getActivity()).onOkClicked();
                        dialog.cancel();
                    }
                })
                .setNeutralButton("На паузе",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
                                ((MainActivity)getActivity()).onNeutralClicked();
                                dialog.cancel();
                            }
                        })
                .setNegativeButton("Нет",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
                                ((MainActivity)getActivity()).onCanselClicked();
                                dialog.cancel();
                            }
                        });
        return builder.create();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return super.onCreateView(inflater,container,savedInstanceState);
    }
}
