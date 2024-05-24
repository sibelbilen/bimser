@home @web

Feature: ana ekran

Background:


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
  Scenario:
    Given menüye tıklayalım
      And menüye tikladi mi
    Given menü icerisinde bulunan sistem tabina tikla
    Given menü icerisinde bulunan sistem tabina tikla ve çıkan menüden ortak tanımlara tikla
    Given menü icerisinde bulunan sistem tabina tikla ve çıkan menüden ortak tanımlara tikla bu menüden çikan tail günlerine tikla

