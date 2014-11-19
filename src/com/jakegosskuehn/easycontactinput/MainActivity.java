package com.jakegosskuehn.easycontactinput;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;





public class MainActivity extends Activity {
    public SharedPreferences sp;
    public SharedPreferences.Editor e;
    
public boolean sexybox = false;
public boolean automaticsms = sexybox;
public String checkboxtext;
public String checkboxmessage;
public String smsbody;
public String smsintroduction = "voidsauce";

    public String finishedtext(String userstring)
    {
        
        smsintroduction = sp.getString("intro", "");
        smsbody = sp.getString("body", "");
        checkboxtext = sp.getString("checkbody", "");
        checkboxmessage = sp.getString("checkboxdescr", "");
        
        if(smsintroduction.isEmpty()) 
        {
            if(smsbody.isEmpty())
            {
                if(checkboxtext.isEmpty())
                    
                {
                    if(checkboxmessage.isEmpty()) //topkek for most AND statements Ive ever put in in if/then form
                    {
                        //Essentially the DEFAULT if they're ALL null
                        smsbody = "Hi "+ userstring +". I just met you. The phone is sending us both a text so we have eachother's numbers. ";
                    }
                }
            }
        }



        
        Toast.makeText( this, "Wait for it, then press send!", Toast.LENGTH_LONG).show();
        
        String thetext = "";
        String Namestring = "Hi " + userstring + ", this is "+ smsintroduction + ".";
        
        thetext = Namestring + " " + smsbody + " " + checkboxtext;
        
        return thetext;
    }


    public void clear() {

        EditText et = (EditText)findViewById(R.id.edit_name);
        EditText et2 = (EditText)findViewById(R.id.edit_number);
        et.setText("");
        et2.setText("");

    } 
    
    public boolean trollchecker()
    {
        EditText usernumber = (EditText) findViewById(R.id.edit_number);
        String usernumberstring = usernumber.getText().toString();
        
        String a ="1111111111";
        String b ="222222222";
        String c ="3333333333";
        String d ="4444444444";
        String e ="5555555555";
        String f ="6666666666";
        String g ="7777777777";
        String h ="8888888888";
        String i ="9999999999";
        String j ="0000000000";
        String k ="1234567890";
        
        if(usernumberstring.equals(a) || usernumberstring.equals(b) || usernumberstring.equals(c)
                || usernumberstring.equals(d)
                || usernumberstring.equals(e)
                || usernumberstring.equals(f)
                || usernumberstring.equals(g)
                || usernumberstring.equals(h)
                || usernumberstring.equals(i)
                || usernumberstring.equals(j)
                || usernumberstring.equals(k))
        {
            return true;
        }
        
        return false;
    }
    
    public void sexyBoolean(View view){ // changes the value from true to false etc
        
        if(sexybox == false)
            {
            sexybox = true;
            
            Context context = getApplicationContext();
            CharSequence text = ":)";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
            v.setTextColor(Color.CYAN);
            toast.show();
            
            }
        else 
        {
            sexybox = false;
            
            Context context = getApplicationContext();
            CharSequence text = ":(";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
            v.setTextColor(Color.CYAN);
            toast.show();
        }
            
    }
    
    
    public void sendText(View view) {
        

        
        
        
//        //changed from ACTION_VIEW to ACTION_SEND_TO
//        
//        
//        //gives me user and number to be used.
        EditText username = (EditText) findViewById(R.id.edit_name);
        EditText usernumber = (EditText) findViewById(R.id.edit_number);
        String usernamestring = username.getText().toString();
        String usernumberstring = usernumber.getText().toString();
        int numbersize = usernumberstring.length();
        
        String uri = "smsto:" +  usernumberstring;
        
        Uri uriU = Uri.parse(uri); 
        Intent it = new Intent(Intent.ACTION_SENDTO, uriU); 
//        it.putExtra("sms_body", "Here you can set the SMS text to be sent, " + usernamestring ); 
//        startActivity(it); 
//        
//        Intent smsIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse(uri));
//        
//                
        //checks if its null fields:
        
        if((numbersize < 7) && (numbersize > 0)) 
        {
            Context context = getApplicationContext();
            CharSequence text = "You have a " + numbersize +  " digit phone number? Try again.";
            
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
            v.setTextColor(Color.CYAN);
            toast.show();
            return;
        }
        if(usernamestring.isEmpty())
        {
            Context context = getApplicationContext();
            CharSequence text = "What's your name?";
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
            v.setTextColor(Color.CYAN);
            toast.show();
            return;
        }
        if(usernumberstring.isEmpty())
        {
            Context context = getApplicationContext();
            CharSequence text = "What's your numbah?";
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
            v.setTextColor(Color.CYAN);
            toast.show();
            return;
        }
        if(trollchecker())
        {
            Context context = getApplicationContext();
            CharSequence text = "Thats not your number...";
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
            v.setTextColor(Color.CYAN);
            toast.show();
            return;
        }
//
//        
//        
//        
//       
        String body = "Hi! This is " + usernamestring + " and I'm sending a self text so we can talk or whatever. ";
        //IF CUTE button toggled
            if(sexybox == true)
            {
                body = body + "I also think you're cool ;)";
            }
            
            //CHANGED BODY for smsbody to this below:
            String editedbody = finishedtext(usernamestring);
//
//
//        
//        smsIntent.putExtra("sms_body", editedbody); //obvi the message
            it.putExtra("sms_body", editedbody); //obvi the message
//        
//        //dont need since SEND_TO
//        //smsIntent.putExtra("address", usernumberstring); //obvi the number, replace usernumberstring
//        
//        smsIntent.setType("vnd.android-dir/mms-sms"); // guess i leave this alone
//        smsIntent.putExtra("compose_mode", true);
//        
//
//        
//        //sends message right before it goes to new view with intent
//        if(sexybox)
//        {
//            Context context = getApplicationContext();
//            CharSequence text = "Thanks " + usernamestring +  " ;)";
//            int duration = Toast.LENGTH_LONG;
//
//            Toast toast = Toast.makeText(context, text, duration);
//            TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
//            v.setTextColor(Color.CYAN);
//            toast.show();
//            
//        }
//        else
//        {
//           
//            
//                Context context = getApplicationContext();
//                CharSequence text = "Thanks " + usernamestring + "!";
//                int duration = Toast.LENGTH_SHORT;
//
//                Toast toast = Toast.makeText(context, text, duration);
//                TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
//                v.setTextColor(Color.CYAN);
//                toast.show();
//                
//            
//        }
//        
//        startActivity(smsIntent);
            startActivity(it); 
    }

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        
        //
        //  sp= PreferenceManager.getDefaultSharedPreferences(getApplicationContext()); // forget about
        sp = getSharedPreferences("contactapp", 0);
        // named preferences - get the default ones and finish with it
//        e = sp.edit();
        
        //SET TEXTS
        

        smsintroduction = (sp.getString("intro", ""));
        smsbody = (sp.getString("body", ""));
        checkboxtext = (sp.getString("checkbody", ""));
        checkboxmessage = (sp.getString("checkboxdescr", ""));
//        
//        TextView tv = (TextView) findViewById(R.id.sexycheckbox);
//        tv.setText("test");
//        
//        CheckBox cb = (CheckBox) findViewById(R.id.sexycheckbox);
//   cb.setText("test2");
        
        
        
        ////TOPCLEAR
        TextView tt = (TextView)findViewById(R.id.toptext2);
        tt.setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {

                EditText et = (EditText)findViewById(R.id.edit_name);
                        EditText et2 = (EditText)findViewById(R.id.edit_number);
                        et.setText("");
                        et2.setText("");
                        CheckBox sexycheck;
                         sexycheck = (CheckBox)findViewById(R.id.sexycheckbox);
                        if (sexycheck.isChecked()) {
                            sexycheck.setChecked(false);
                        }
            }
        });
        
        ////
        
        
    }
    @Override
    protected void onResume(){
        
        super.onResume();
        //TESTPOST PLEASE IGNORE this too
//        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        setContentView(R.layout.activity_main);
//        
//        sp = getSharedPreferences("contactapp", 0);
//        
//        smsintroduction = (sp.getString("intro", ""));
//        smsbody = (sp.getString("body", ""));
        checkboxmessage = (sp.getString("checkboxdescr", ""));
//        checkboxmessage = (sp.getString("checkboxdescr", ""));
        
        CheckBox tv1 = (CheckBox) findViewById(R.id.sexycheckbox);
        tv1.setText(checkboxmessage);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // three lines below are default
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
        
        // Make MenuInflater
       // MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.menu, menu); //MENU.MENU DOESNT EXIST?
     //   inflater.inflate(R.menu.main, menu);
//        sp = getSharedPreferences("prefs", 0);
        //MENU//
        
        //ACTION BAR?
        //
        
        getMenuInflater().inflate(R.menu.main, menu);
        
        menu.add(1, 1, Menu.FIRST, "Settings");
        menu.add(1, 2, Menu.FIRST +1, "Clear fields");
        menu.add(1, 3, Menu.FIRST +2, "Feedback");
        menu.add(1, 4, Menu.FIRST +3, "About");
        
        
        
        boolean firstRun = sp.getBoolean("firstRun", true);
        //lol
        if ( firstRun ){
          sp.edit().putBoolean("firstRun", false).commit();
            AlertDialog.Builder ad = new AlertDialog.Builder(this);  
            
          checkboxtext = "I think you're hot too!";
           
            smsbody = "Sending a self text so we can talk or whatnot.";
           smsintroduction = "Hi there!";
            
            
            ad.setTitle("Hey there new user!");  
            ad.setMessage("- Thanks for trying my app out. \n Check out the settings -> help to edit what the user will see. You also need to give the app your first name \n - A customized message will form, they will see it and send it to themselves. \n Best of luck to you, just hand this to a person and get numbers!!!"); 
            ad.setNegativeButton("OK", new DialogInterface.OnClickListener() {  
               public void onClick(DialogInterface dialog, int id) {  
                 dialog.dismiss(); 
            }  
            });  
            ad.show();
        }
    // Return True
    return true;
    }
    
    public void toasttester() //toasts and takes you to the settings...
    {
        Context context = getApplicationContext();
        CharSequence text = "Settings Menu";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
        v.setTextColor(Color.CYAN);
        toast.show();
        
        Intent in = new Intent(MainActivity.this, settingmenu.class);
        
        startActivity(in);
        setResult(Activity.RESULT_OK);
        
    }
    
    public void feedbackintent() //toasts and takes you to the settings...
    {
//        Context context = getApplicationContext();
//        CharSequence text = "Feedback";
//        int duration = Toast.LENGTH_SHORT;
//
//        Toast toast = Toast.makeText(context, text, duration);
//        TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
//        v.setTextColor(Color.CYAN);
//        toast.show();
        
        Intent in = new Intent(MainActivity.this, feedback.class);
        
        startActivity(in);
        setResult(Activity.RESULT_OK);
        
    }
    
    public void haspref(String key) //toasts and tells you if has preference
    {
        Context context = getApplicationContext();
        CharSequence text = "YUP CAN HAS MATCH";
        int duration = Toast.LENGTH_SHORT;
        
        if(sp.contains(key))
        {
        

        Toast toast = Toast.makeText(context, text, duration);
        TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
        v.setTextColor(Color.CYAN);
        toast.show();
        }
        
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) { //since int IDS are 1-4
            case 1:
                toasttester();
                return true;
            case 2: //clear
                clear();
                return true;
            case 3:
                feedbackintent();
                return true;
            case 4:
                feedbackintent();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    
    
}
