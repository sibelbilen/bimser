@web @negatif
  Feature:

    Background: Given sisteme "url" ile giriş yapilmalidir
      Given sisteme giris yaptiğini assert et
      And  sistemde şirket secimi yapabilmek icin taba basilmalidir
      And  sistemde şirket secimi yapilmalidir
    Scenario:

And kullanici adini yanlış giriş yapalim
And kullanici passwordunu negatif yazalim
      And sisteme giris yapalim
And kullanici yanlış kullanici ve password girişi yaptığında hata mesajı geldi mi
      And tamam'a bas



    Scenario: Boş Kullanıcı Adı ve Şifre ile Giriş Denemesi

      And kullanıcı adı alanı boş bırakılır
      And kullanıcı şifre alanı boş bırakılır
      And sisteme giris yapalim
      And kullanici yanlış kullanici ve password girişi yaptığında hata mesajı geldi mi
      And tamam'a bas


    Scenario: Kullanıcı Adı ve Şifre Uzunluğu Kontrolü

      And kullanıcı adını üç karakterden daha kısa girelim
      And kullanıcı şifresini beş karakterden daha kısa girelim
      And sisteme giris yapalim
      And kullanici yanlış kullanici ve password girişi yaptığında hata mesajı geldi mi
      And tamam'a bas


    Scenario: Hatalı Kullanıcı Adı ile Giriş Denemesi

      And kullanıcı adını yanlış giriş yapalım
      And kullanıcı şifresini doğru girelim
      And sisteme giris yapalim
      And kullanici yanlış kullanici ve password girişi yaptığında hata mesajı geldi mi
      And tamam'a bas
    Scenario: Hatalı Şifre ile Giriş Denemesi

      And doğru kullanıcı adını girelim
      And kullanıcı şifresini yanlış girelim
      And sisteme giris yapalim
      And kullanici yanlış kullanici ve password girişi yaptığında hata mesajı geldi mi

      And tamam'a bas

