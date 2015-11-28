
import java.util.Scanner;

/**
 *
 * @author Eren Çetinkaya Cruz
 */
public class AltKumeBulma {

    public static void main(String[] args) {

        //Kumemizin eleman sayısını alıyoruz	
        Scanner okuyucu = new Scanner(System.in);
        System.out.print("Kumenin eleman sayısını giriniz : ");
        int elemanSayisi = okuyucu.nextInt();

        //Kumemizin elemanlaarını kume isimli diziye atıyoruz
        int kume[] = new int[elemanSayisi];
        for (int i = 0; i < elemanSayisi; i++) {
            System.out.print((i + 1) + ". Eleman: ");
            kume[i] = okuyucu.nextInt();
        }

        //Kümemizi yazdırıyoruz
        System.out.print("{");
        for (int i = 0; i < elemanSayisi; i++) {
            System.out.print(kume[i]);
            if (i != elemanSayisi - 1) {
                System.out.print(",");
            }
        }
        System.out.print("}");
        System.out.println(" kümesinin alt kümeleri ");

        //Alt kümelerimizin sayısını bulduruyoruz ve altküme dizimizi oluşturuyoruz
        int altKumeSayisi = (int) Math.pow(2, (elemanSayisi));
        String altKumeler[] = new String[altKumeSayisi];        
        String altKume = "";

        int sayi = 0;
        int sayac = 0;
        for (int i = 0; i < altKumeSayisi; i++) {
            sayi = i;
            altKume = "{";
            sayac = 0;
            
            for (int j = 0; j < elemanSayisi; j++) {
                //gelinen sayının 2 ye modu alınır böylece binary sistemde varlığı kontrol edilir
                if (sayi % 2 == 1) {
                    if (sayac == 0) {
                        altKume += kume[j];
                    } else {  //alt kümelerde 2 ve daha fazla eleman varsa yazdırmak için kullanılır
                        altKume += "," + kume[j];
                    }
                    sayac++;
                }
                //sayı 2 den küçük ise artık kontrole gerek kalmaz döngüden çıkılır
                if (sayi == 1) {
                    break;
                }
                // burada bilinen decimal sayıyı binary' e çevirme işlemi yapılır(2 ye bölme)
                if (sayi >= 2) {
                    sayi = sayi / 2;
                }
            }
            //Bulunan elemanlar bir string te tutulur ve bu string de bir diziye eklenir
            altKume += "}";
            altKumeler[i] = altKume;
            altKume = "{";
        }

        String temp = "";   // Yer değiştirmede kullanılacak geçici değişken
        // Her karşılaştırmadan sonra yeniden kaldığımız yerden devam etmemizi sağlayan döngü
        for (int i = 1; i < altKumeSayisi; i++) {
            // Dizinin ardışık elamanlarını karşılaştırmak için kullandığımız döngü
            for (int j = 0; j < altKumeSayisi - i; j++) {
                //Önce gelen elaman bir sonrakinden büyükse(karakter sayısı) ikisi yer değiştiriyor
                if (altKumeler[j].length() > altKumeler[j + 1].length()) {
                    temp = altKumeler[j];
                    altKumeler[j] = altKumeler[j + 1];
                    altKumeler[j + 1] = temp;
                }
            }
        }

        //Alt kümeleri yazdır
        for (int i = 0; i < altKumeSayisi; i++) {
            System.out.println((i + 1) + ". "+altKumeler[i]);
        }

    }
}
