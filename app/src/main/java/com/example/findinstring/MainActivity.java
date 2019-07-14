package com.example.findinstring;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn;
    String kw;
    EditText dic;
    EditText words;
    // String w;
    TextView tvfound, tvkarisik, tvword;
    String a;
    String bulunan;
    int coor;
    byte lFound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.lbtn);
        dic = (EditText) findViewById(R.id.ledtdic);
        words = (EditText) findViewById(R.id.ledtword);

      //  tvfound = (TextView) findViewById(R.id.ltvfound);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


               // String karisik = "mldi frkn bsue rtane rosortcisoesrliael raiginnephopshoirc mero rkanfu asa";
                String karisik = words.toString();
                // String word = "melodi furkan  buse argillocalcareous argininephosphoric omer arithmetico-geometric ats ertan arithmetico-geometrical arithmetizations armour-piercing ar'n't ARPANET arsenophenylglycin arteriocapillary arterioloscleroses arteriolosclerosis arteriosympathectomy arthrosynovitis artsy-craftsiness ASA/BS ASAIGAC asbestos-corrugated asbestos-protected ASHRAE Ashton-under-Lyne aspidobranchiate assumptiveness asterospondylous astragalocalcaneal astragaloscaphoid astrochronological astrometeorologist astrophotographer astrophotometry astrospherecentrosomic";
                String word =  dic.toString();
                String[] akarisik = karisik.split(" ");
                String[] aword = word.split(" ");
                bulunan = "";
                String wordbk;
                System.out.println("" + aword.length);

                for (int ik = 0; ik < akarisik.length; ik++) {
                    for (int iw = 0; iw < aword.length; iw++) {
                        word = aword[iw];

                        karisik = akarisik[ik];
                        System.out.println("------------------------------------------------");
                        System.out.println(word + " is searcing in "+karisik);
                        System.out.println("------------------------------------------------");
//                        if (karisik.length() == word.length()) {
                        if (karisik.length() == karisik.length()) {
                            lFound = 1;
                            for (int i = 0; i < karisik.length(); i++) {    //harflere teker teker ulasmak icin yaptik
                                //    if (karsık.substring(0,karisik.length()))
                                a = karisik.substring(i, i + 1);     //karisigin i ninci harfini buluyoruz
                                coor = word.indexOf(a);                     //karisigin i ninci harfini word un icinde aradik
                                // w=a.contains(word.substring(0,karisik.length()));
                                if (coor > -1) {
//                                    System.out.println("Aranacak Harf "+a);
//                                    System.out.println("Word=" + word+"<"); //+ " Backup =  ");
                                    wordbk = word;

                                    word="";
                                    if (coor > 0) {
                                        word = wordbk.substring(0, coor );
                                    }
                                    word = word + " ";
                                    if (coor < wordbk.length()) {
                                        word = word + wordbk.substring(coor+1 , wordbk.length());
                                    }
 /*                                   System.out.println(a);
                                    System.out.println(" ");
                                    System.out.println(word);
 */
                                } else {
                                    System.out.println("this is not :(" + akarisik[ik]);
                                    lFound = 0;

                                }

                            }
                            if (lFound == 1) {
                                System.out.println("we fouuuuund :) " + word);
                                System.out.println(akarisik[ik]);
                                System.out.println("dic:::" + aword[iw]);
                                bulunan = bulunan + "\n" + akarisik[ik] + "=" + word;
                                dic.setText(bulunan);
                                // tvfound.setText("we fouuuund :) ==> " + word +"\n" + akarisik[ik] + "\n"+aword[iw]);
                                iw = aword.length + 1;
                            }
                            else
                            {
                                int nSpacecount=0;
                                for  (int i = 0; i < word.length(); i++) {
                                    a = word.substring(i, i + 1);
                                    if(a.equals(" ")){
                                        nSpacecount++;
                                    }
                                }
//                                if(nSpacecount<2){
                                System.out.println(word.length()- nSpacecount + " hata  ile bulduk) " + aword[iw]);
//                                }
                            }
                        }
                    }

                }


            }
        });
    }
}
