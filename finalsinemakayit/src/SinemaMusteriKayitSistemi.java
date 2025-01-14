import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// BaseEntity Class (Temel Sınıf)
abstract class BaseEntity {
    protected int id;
    protected String name;

    public BaseEntity(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public abstract void bilgiGoster();
}

// Interface Tanımı
interface IKayit {
    void kaydet();
}

// Musteri Sınıfı
class Musteri extends BaseEntity implements IKayit {
    private String email;

    public Musteri(int id, String name, String email) {
        super(id, name);
        this.email = email;
    }

    @Override
    public void bilgiGoster() {
        System.out.println("Müşteri ID: " + id + ", İsim: " + name + ", Email: " + email);
    }

    @Override
    public void kaydet() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);

            List<Musteri> musteriler = new ArrayList<>();
            File file = new File("Musteri.json");

            if (file.exists()) {
                Musteri[] existingMusteriler = mapper.readValue(file, Musteri[].class);
                musteriler.addAll(Arrays.asList(existingMusteriler));
            }

            musteriler.add(this);
            mapper.writeValue(file, musteriler);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// Film Sınıfı
class Film {
    private String ad;
    private int sure;
    private String tur;

    public Film(String ad, int sure, String tur) {
        this.ad = ad;
        this.sure = sure;
        this.tur = tur;
    }

    public String getAd() {
        return ad;
    }

    public int getSure() {
        return sure;
    }

    public String getTur() {
        return tur;
    }

    @Override
    public String toString() {
        return "Film Adı: " + ad + ", Süre: " + sure + " dakika, Tür: " + tur;
    }
}

// Salon Sınıfı
class Salon extends BaseEntity implements IKayit {
    private List<Film> filmler;
    private List<Musteri> musteriler;

    public Salon(int id, String name) {
        super(id, name);
        this.filmler = new ArrayList<>();
        this.musteriler = new ArrayList<>();
    }

    public void filmEkle(Film film) {
        filmler.add(film);
    }

    public void musteriEkle(Musteri musteri) {
        musteriler.add(musteri);
    }

    public List<Film> getFilmler() {
        return filmler;
    }

    public List<Musteri> getMusteriler() {
        return musteriler;
    }

    @Override
    public void bilgiGoster() {
        System.out.println("Salon ID: " + id + ", İsim: " + name);
    }

    @Override
    public void kaydet() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);

            List<Salon> salonlar = new ArrayList<>();
            File file = new File("Salon.json");

            if (file.exists()) {
                Salon[] existingSalonlar = mapper.readValue(file, Salon[].class);
                salonlar.addAll(Arrays.asList(existingSalonlar));
            }

            salonlar.add(this);
            mapper.writeValue(file, salonlar);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// Main Class
public class SinemaMusteriKayitSistemi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Yeni Müşteri Ekle\n2. Yeni Film Ekle\n3. Yeni Salon Ekle\n4. Çıkış\nSeçiminizi Yapın: ");
            int secim = scanner.nextInt();
            scanner.nextLine(); // Boşluğu temizle

            switch (secim) {
                case 1:
                    System.out.print("Müşteri ID: ");
                    int musteriId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Müşteri İsmi: ");
                    String musteriIsim = scanner.nextLine();
                    System.out.print("Müşteri Email: ");
                    String musteriEmail = scanner.nextLine();

                    Musteri musteri = new Musteri(musteriId, musteriIsim, musteriEmail);
                    musteri.kaydet();
                    System.out.println("Müşteri kaydedildi.");
                    break;

                case 2:
                    System.out.print("Film Adı: ");
                    String filmAdi = scanner.nextLine();
                    System.out.print("Film Süresi (dk): ");
                    int filmSure = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Film Türü: ");
                    String filmTur = scanner.nextLine();

                    Film film = new Film(filmAdi, filmSure, filmTur);
                    System.out.println("Film: " + film);
                    break;

                case 3:
                    System.out.print("Salon ID: ");
                    int salonId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Salon İsmi: ");
                    String salonIsim = scanner.nextLine();

                    Salon salon = new Salon(salonId, salonIsim);
                    salon.kaydet();
                    System.out.println("Salon kaydedildi.");
                    break;

                case 4:
                    System.out.println("Çıkış yapılıyor...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Geçersiz seçim!");
            }
        }
    }
}
