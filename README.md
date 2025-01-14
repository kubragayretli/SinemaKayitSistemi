Bu proje, bir sinema sisteminde müşteri, film ve salon bilgilerini yönetmek üzere tasarlanmış bir Java uygulamasıdır. Uygulama, JSON formatında veri kaydederek basit bir veri kayıt ve yönetim sistemi sunar. Projede Java, Jackson Kütüphanesi ve Nesne Yönelimli Programlama (OOP) teknikleri kullanılmıştır.

Projenin Temel Özellikleri
Müşteri Kayıt: Yeni müşteriler oluşturup JSON formatında kaydedebilirsiniz.
Film Ekleme: Yeni filmler oluşturabilirsiniz (JSON kayıt işlevi eklenmemiştir).
Salon Kayıt: Yeni sinema salonları oluşturup JSON formatında kaydedebilirsiniz.
JSON Destekli Veri Kaydetme: Müşteri ve salon verileri JSON dosyalarına kaydedilir ve tekrar yüklenebilir.

Kullanılan Teknolojiler
Java: Uygulama dili olarak kullanılmıştır.
Jackson Kütüphanesi: JSON formatında veri kaydetmek ve okumak için kullanılmıştır.
Nesne Yönelimli Programlama (OOP): Kalıtım, soyutlama ve arabirimler kullanılarak uygulama tasarlanmıştır.

Proje Sınıfları
1. BaseEntity (Soyut Sınıf)
ID ve isim gibi temel alanları barındırır.
bilgiGoster() adında soyut bir metot içerir.

2. IKayit (Arabirim)
kaydet() metodunu tanımlar. JSON formatında kaydetme işlevi için kullanılmıştır.

3. Musteri (Türetilmiş Sınıf)
Müşteri bilgilerini (ID, isim ve email) tutar.
JSON formatında dosyaya kaydedebilir.

4. Film
Film adı, süresi ve türü bilgilerini tutar.
Bir film oluşturulduğunda konsolda bilgilerini yazdırır.

5. Salon (Türetilmiş Sınıf)
Sinema salonlarının bilgilerini tutar.
Filmleri ve müşterileri liste olarak saklar.
JSON formatında dosyaya kaydedebilir.

6. SinemaMusteriKayitSistemi (Ana Sınıf)
Kullanıcıdan veri alıp ilgili sınıflarla işlem yapar.
Aşağıdaki işlemleri gerçekleştirir:
Yeni müşteri ekleme ve kaydetme.
Yeni film ekleme (konsolda gösterme).
Yeni salon ekleme ve kaydetme.
Programdan çıkış.

Lisans
Bu proje MIT Lisansı altında kullanıma sunulmuştur.
