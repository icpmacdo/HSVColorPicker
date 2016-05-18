package com.algonquincollege.macd0719.hsvcolorpicker;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Created by IanMacDonald on 2015-10-21.
 */
public class AboutDialogFragment extends DialogFragment{
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){

        AlertDialog.Builder builder = new AlertDialog.Builder( getActivity() );

        builder.setTitle(R.string.action_about)
                .setMessage(R.string.creatorName)
                .setCancelable(false)
                .setPositiveButton( R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick( DialogInterface dialog, int which ) {
                        dialog.cancel();
                    }
                });


        return builder.create();

    }

}
