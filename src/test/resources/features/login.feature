@web @login
  Feature: login

   Scenario:
      Given sisteme "url" ile giriş yapilmalidir
      Given sisteme giris yaptiğini assert et
      And  sistemde şirket secimi yapabilmek icin taba basilmalidir
      And  sistemde şirket secimi yapilmalidir
      And kullanici adini yazalim
      And kullanici passwordunu yazalim
      And sisteme giris yapalim
      And sistem menüsüne giriş yapıldı mi  assert et
      And sistem menüsüne checkBoxı secili mi
      And sistem menüsüne gelen devam butonuna basalım
      And sistem yöneticici ana ekranina geldi mi

