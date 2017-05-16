package pe.cibertec.fragmentsdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class ContactActivity extends AppCompatActivity {

    public static final String EXTRA_CONTACT = "contact";

    private Contact contact,contactoNuevo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            // During initial setup, plug in the details fragment.
            contact = getIntent().getParcelableExtra(EXTRA_CONTACT);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(android.R.id.content, ContactFragment.newInstance(contact));
            ft.commit();
        }
        contact = getIntent().getParcelableExtra(EXTRA_CONTACT);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(android.R.id.content, ContactFragment.newInstance(contact));
        ft.commit();
    }
}
