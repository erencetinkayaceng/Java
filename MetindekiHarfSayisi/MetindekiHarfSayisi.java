// Metindeki harf sayisi örneği
// Konsoldan girilen bir metnin içinde geçen harflerin sayısını bulur.
// Hangi harften kaçtane var ise çıktı verir 
// Not:Büyük-küçük ayrımı yapılmaz

import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author Eren Çetinkaya Cruz
 */
public class MetindekiHarfSayisi {

    public static void ciktiVer(Harf[] harfDizisi) {
        for (int i = 0; i < harfDizisi.length; i++) {
            System.out.println(harfDizisi[i].getCh() + " -> " + harfDizisi[i].getSayi());
        }
    }

    public static String cumleyiAl() {

        Scanner sc = new Scanner(System.in);
        String cumle = "", geciciCumle = "";

        System.out.println("Bir cümle giriniz...");
        cumle = sc.nextLine();
        cumle=cumle.toUpperCase(); 
        
        //cümleden harf dışındaki karakterleri çıkarıyoruz
        for (int i = 0; i < cumle.length(); i++) {
            char ch=cumle.charAt(i);
            if (ch < 'A' || ch > 'Z') {
                continue;
            }
            geciciCumle += cumle.charAt(i);
        }

        return geciciCumle;
    }

    public static int kacFarkliHarfVarKontrolEt(String cumle) {
        int farkliElemanSayisi = 0;
        cumle = cumle.toUpperCase();

        //Dizi icerisinde aynı elemanı barındırmaz		
        TreeSet ts = new TreeSet();

        for (int i = 0; i < cumle.length(); i++) {
            ts.add(cumle.charAt(i));
        }

        farkliElemanSayisi = ts.size();
        return farkliElemanSayisi;
    }

    public static Harf[] harfSay(String cumle) {
        Harf harfDizisi[] = null;
        int farkliHarfSayisi = 0;
        int sayac = 0;

        farkliHarfSayisi = kacFarkliHarfVarKontrolEt(cumle);
        //harf dizimizi burada oluşturuyoruz
        harfDizisi = new Harf[farkliHarfSayisi];

        // cumlenin tum harflerini tektek konrol ediyoruz
        for (int i = 0; i < cumle.length(); i++) {
            char kontrolEdilecekHarf = cumle.charAt(i);

            int ayniHarfSayisi = ayniHarfSaysiniBul(cumle, kontrolEdilecekHarf);

            //aynı harften yok baska bir harf buyuzden dizimize ekliyoruz
            if (!aynisindanHarfDizisindeVarMi(harfDizisi, kontrolEdilecekHarf)) {
                //diziye yeni harf oluşturup ekliyoruz
                harfDizisi[sayac] = new Harf(kontrolEdilecekHarf, ayniHarfSayisi);
                sayac++;
            }
        }

        return harfDizisi;
    }

    public static int ayniHarfSaysiniBul(String cumle, char _ch) {
        int aynıHarfSayisi = 0;
        // aynı harften kaç tane var
        for (int i = 0; i < cumle.length(); i++) {
            if (_ch == cumle.charAt(i)) {
                aynıHarfSayisi++;
            }
        }
        return aynıHarfSayisi;
    }

    public static boolean aynisindanHarfDizisindeVarMi(Harf[] harfDizisi, char _ch) {

        boolean ayniHarfVar = false;

        for (int i = 0; i < harfDizisi.length; i++) {
            if (harfDizisi[i] != null) { // dizi öğesi boş değilse kontrol yap
                if (_ch == harfDizisi[i].getCh()) {
                    ayniHarfVar = true;
                }
            }
        }

        return ayniHarfVar;
    }

    public static void main(String[] args) {
        Harf harfDizisi[] = null;
        String cumlemiz = "";

        cumlemiz = cumleyiAl();

        harfDizisi = harfSay(cumlemiz);

        ciktiVer(harfDizisi);
    }
}

//Cumledeki harfleri temsil etmek için sınıf oluşturuyoruz
class Harf {

    char ch;
    int sayi;

    public Harf() {

    }

    public Harf(char _ch, int _sayi) {
        this.ch = _ch;
        this.sayi = _sayi;
    }

    public char getCh() {
        return ch;
    }

    public void setCh(char ch) {
        this.ch = ch;
    }

    public int getSayi() {
        return sayi;
    }

    public void setSayi(int sayi) {
        this.sayi = sayi;
    }
}
