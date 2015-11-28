
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Eren Çetinkaya Cruz
 */
public class SayiTahminOyunu {

    public static void main(String[] args) {

        int bulunmasiGerekenSayi;
        int tahminSayisi, tahminEtmeSayaci = 1;
        Scanner okuyucu = new Scanner(System.in);
        Random rnd = new Random();

        //random olarak 0-100 arası sayı üretip rastSayi adlı değişkenimize atıyoruz
        bulunmasiGerekenSayi = rnd.nextInt(100);

        System.out.println("Sayıyı bulmak için kaç tahmin hakkınız olsun ? :");
        tahminSayisi = okuyucu.nextInt();

        int tahminEdilenSayi = 0;
        boolean oyunaDevam = true;// oyunun devam edip etmemesini kontrol için kullanılacak

        System.out.println("0-100 arası bir sayi giriniz : ");

        while (oyunaDevam) {

            //okuyucudan bir sayı tahmin etmesini istiyoruz
            tahminEdilenSayi = okuyucu.nextInt();

            //tahmin edilen sayi rastgele oluşturulan sayıya eşitse tebrik edip döngüden çıkıyoruz
            if (tahminEdilenSayi == bulunmasiGerekenSayi) {
                System.out.println("Tebrikler sayıyı " + tahminEtmeSayaci + ". tahminde buldunuz ... ");
                oyunaDevam = false;
                //yapmış olduğumuz tahmin sayisi bulmak istediğimmiz tahmin sayısından fazla ise oyunu bitiriyoruz
            } else if (tahminEtmeSayaci > tahminSayisi - 1) {
                System.out.println("Oyunu kaybettiniz, bulmanız gereken sayı " + bulunmasiGerekenSayi + " idi.");
                oyunaDevam = false;
            }//tahmin edilen sayı ile rastgele sayı karşılaştırılıp duruma göre yeniden sayı istiyoruz
            else if (tahminEdilenSayi > bulunmasiGerekenSayi) {
                System.out.println("Daha küçük bir sayı giriniz :");
            } else if (tahminEdilenSayi < bulunmasiGerekenSayi) {
                System.out.println("Daha büyük bir sayı giriniz :");
            }

            tahminEtmeSayaci++;

        }

    }
}
