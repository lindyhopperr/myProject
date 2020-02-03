Kodları uygulamanın çalıştırılabilmesi için;

1-Kodları lokale indirdikten sonra 
  maven clean install
  
  
2- Oluşan jar'ı ise aşağıdaki komut ile çalıtırmanız yeterli olucaktır.
  java -jar target/demo-0.0.1-SNAPSHOT.jar
  
  
Notlar:
 - app.log dosyası uygulama tarafından uygulama hangi uzantıda çalıştırılıyorsa o uzantıda sistem bir kez çalıştırıldığında oluşturulucaktır
 Uygulama kapandıktan sonra da içerik silinmeyecek üzerinde yazılacaktır.
 -application.properties dosyasında aşağıdaki parametreleri değiştirebilirsiniz.
    schedular=0/10 * * * * ?
    data_file_path=C:\\works\\app.json
  -Uygulamada eksik olarak tüm istekler Rest api ile yapılmıştır. 
  Tüm subcriber ları görebilmek için /getAllSubscribers rest endpointini kullanmanız yeterlidir.

app.json dosyasına aşağıdaki şekilde veri kaydedilmektedir.
[
  {
    "id": "0",
    "name": "xxxx",
    "msisdn": "237837"
  },
  {
    "id": "2",
    "name": "yyyyy",
    "msisdn": "237837"
  },
  {
    "id": "3",
    "name": "zzz",
    "msisdn": "237837"
  }
]
