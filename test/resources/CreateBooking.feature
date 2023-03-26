Feature: Kullanici olarak rezervasyon olusturabilirim
  Scenario: Kullanici otel rezervasyonu yapabilir ve silebilir
    Given Kullanici yeni bir rezervasyonu olusturuyor
    And Kullanici rezervasyonu icin gereken bilgileri veriyor
    When Kullanici otel rezervasyonu yaratiyor
    Then rezervasyonu basarili sekilde olusturuldu
    And Kullanici olusturulan rezervasyonu iptal ediyor