package pe.cibertec.fragmentsdemo;

import android.content.Intent;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity
        implements ListFragment.OnContactClickListener {

    private boolean isDualPane = false;
    Contact contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        isDualPane = getResources().getBoolean(R.bool.dual_pane);


        }

    @Override
    public void onContactClick(Contact contact) {
        if (isDualPane) {
            this.contact=contact;
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.container, ContactFragment.newInstance(contact));
            ft.commit();
        } else {
            Intent intent = new Intent(this, ContactActivity.class);
            intent.putExtra(ContactActivity.EXTRA_CONTACT, contact);
            startActivity(intent);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Contact contact = new Contact();
        contact.setName("Contact "+0);
        contact.setPhone("999 999 999");
        contact.setAddress("XXXXXX 123");
        contact.setEmail("abc@cibertec.pe");
        Calendar calendar = Calendar.getInstance();
        contact.setDob(calendar.getTime());
        ContactFragment fragmentDemo = ContactFragment.newInstance(contact);
        ft.replace(R.id.container,fragmentDemo);
        ft.commit();
    }
}
