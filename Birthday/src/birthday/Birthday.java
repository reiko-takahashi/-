
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package birthday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author r-takahashi
 */
public class Birthday {
    public static void main(String[] args) throws IOException
    {
        // TODO code application logic here
        int yyyy = 0;   //入力した年
        int mm = 0;     //入力した月
        int dd = 0;     //入力した日
        boolean er = true;
        int dw = 0;     // 曜日
        int[] Month = new int[13];
        Month[0] = 0;
        Month[1] = 31;
        Month[2] = 28;
        Month[3] = 31;        
        Month[4] = 30;        
        Month[5] = 31;        
        Month[6] = 30;        
        Month[7] = 31;        
        Month[8] = 31;        
        Month[9] = 30;        
        Month[10] = 31;        
        Month[11] = 30;        
        Month[12] = 31;        
               
        while(true){
            /* 1.誕生日の入力、曜日の予想を入力 */
            //入力を促すメッセージの表示
            while(er = true){
                System.out.println("誕生日を入力してください。（終了する場合はFかfを押してEnter）");

                //誕生日の入力
                //TODO 値の正誤判定    
                BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
                String str1 = br1.readLine();   // "yyyy/mm/dd"を入力
                
                char ch1 = str1.charAt(0);
                if(ch1 == 'F'|| ch1 == 'f' ){
                    System.exit(1);
                }
                
                int idx = 0;
                idx = str1.indexOf('/');
                yyyy = Integer.parseInt(str1.substring(0, idx));    // yyyyまでの文字列を返す
                String str2 = str1.substring(idx+1);    // mm/ddを返す
                
                idx = str2.indexOf('/');
                mm = Integer.parseInt(str2.substring(0, idx));  // mmまでの値を返す
                String str3 = str2.substring(idx+1);    // ddを返す
                
                dd = Integer.parseInt(str3);
                                  
                er = false; //  エラーチェック入れる    
            }

            while(er = true){
                //入力を促すメッセージの表示
                System.out.println("誕生日の曜日を予想してください。（終了する場合はFかfを押してEnter）");

                //曜日の予想
                //TODO 値の正誤判定
                BufferedReader br2 =
                new BufferedReader(new InputStreamReader(System.in));

                String str4 = br2.readLine();
                char ch2 = str4.charAt(0);
                if(ch2 == 'F'|| ch2 == 'f' ){
                    System.exit(1);
                }                  

                switch(ch2){
                    case '日':
                        dw = 1;
                        break;
                    case '月':
                        dw = 2;
                        break;
                    case '火':
                        dw = 3;
                        break;
                    case '水':
                        dw = 4;
                        break;
                    case '木':
                        dw = 5;
                        break;
                    case '金':
                        dw = 6;
                        break;
                    case '土':
                        dw = 7;
                        break;
                }
                er = false;
            }
            
            /* ２.入力された日付から曜日を求める */
            int yyyyc = 2017;
            int mmc = 1;
            int ddc = 1;
            int dwc = 1;
            
            if( yyyy >= yyyyc){     // 2017年以降の処理　++
                // 曜日++
                dwc++;
                //日付++
                ddc++;
               // 日付の判定
                if( Month[mmc] >= ddc){
                    ddc = 1;
                    mmc++;
                    if( mmc >= 13){
                        mmc = 1;
                        yyyyc++;
                        // うるう年の判定
                        if((yyyyc % 4 == 0 && yyyyc % 100 !=0 )||
                                (yyyyc % 4 == 0 && yyyyc % 100 == 0 && yyyyc % 400 == 0)){
                            Month[2] = 29;
                        }
                        else{
                            Month[2] = 28;
                        }
                    }
                }
            }
            
            else{       // 2016年以前の処理　--
                // 曜日--
                dwc--;
                // 日付--
                ddc--;
                // 日付の判定
                if(ddc < 1){
                    mmc--;
                    if(mmc < 1){
                        mmc = 12;
                        yyyyc--;
                        // うるう年の判定
                        if((yyyyc % 4 == 0 && yyyyc % 100 !=0 )||
                                (yyyyc % 4 == 0 && yyyyc % 100 == 0 && yyyyc % 400 == 0)){
                            Month[2] = 29;
                        }
                        else{
                            Month[2] = 28;
                        }
                        
                    }
                    ddc = Month[mmc];
                }
            }
            
            /* ３.メッセージを表示 */
            // ユーザーの予想と比較
            if(dw == dwc){
                System.out.println("正解です、よく何曜日に生まれたか知っていますね。 ");
            }
            else if((dwc - dw == 1) || (dwc - dw == -1) ||(dwc - dw == 6) || (dwc - dw == -6)){
                System.out.println("惜しい、あなたの生まれたのは" + dwc + "曜日ですよ。 ");
            }
            else{
                System.out.println("残念ですが、あなたの生まれた日は" + dwc + "曜日です。 ");
            }
        }
        
        
        
        
    }
    
    
}
