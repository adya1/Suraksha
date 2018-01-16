package com.apkglobal.suraksha;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by dell on 1/11/2018.
 */

public class Register extends Fragment implements View.OnClickListener{
    TextInputLayout namelayout,numberlayout;
    private static EditText name,number;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments
        View view = inflater.inflate(R.layout.contacts_register, container, false);
        namelayout =view.findViewById(R.id.name);
        numberlayout =view.findViewById(R.id.mobile);
         name=view.findViewById(R.id.editText2);
        number=view.findViewById(R.id.editText3);
        Button save=view.findViewById(R.id.save);
        save.setOnClickListener(this);
        return view;
    }




    @Override
    public void onClick(View view) {
        Toast.makeText(getActivity(), "save started", Toast.LENGTH_LONG).show();

       /* name.setHint("Person name");
        number.setHint("Mobile Number");*/
        String str_name = name.getText().toString();
        String str_number = number.getText().toString();
        SQLiteDatabase db = getActivity().openOrCreateDatabase("NumDB", Context.MODE_PRIVATE, null);
        //Toast.makeText(getApplicationContext(), "db created",Toast.LENGTH_LONG).show();

        db.execSQL("CREATE TABLE IF NOT EXISTS details(name VARCHAR,number VARCHAR);");
        //Toast.makeText(getApplicationContext(), "table created",Toast.LENGTH_LONG).show();

        Cursor c = db.rawQuery("SELECT * FROM details", null);
        if (c.getCount() < 2) {
            db.execSQL("INSERT INTO details VALUES('" + str_name + "','" + str_number + "');");
            Toast.makeText(getActivity(), "Successfully Saved", Toast.LENGTH_SHORT).show();
        } else {

            db.execSQL("INSERT INTO details VALUES('" + str_name + "','" + str_number + "');");
            Toast.makeText(getActivity(), "Maximun Numbers limited reached. Previous numbers are replaced.", Toast.LENGTH_SHORT).show();
        }


        db.close();
    }
}

