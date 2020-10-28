$(function () {
    
  /*tooltip用*/
  $('[data-toggle="popover"]').popover();
  
  //現在の天気を取得する場所の名前
  let targetCityName = "okinawa";
  let appId = "804e576d9cfd447db84a22b1e69f906d";

  const requestUrl = "https://api.openweathermap.org/data/2.5/weather?APPID=" + appId + "&lang=ja&units=metric&q=" + targetCityName + ",jp;";

  //Ajax通信用のオブジェクトを作成
  let xhr =new XMLHttpRequest();

  //通信方式とURLを設定
  xhr.open("GET",requestUrl);

  //通信を実行する
  xhr.send();

  //通信ステータスが変わったら実行される関数
  xhr.onreadystatechange = function(){
      //通信が完了
      if(xhr.readyState == 4){
          ShowTodaysWeather(xhr.responseText);
      }
  }

  /**
   * 今日の天気を表示する
   */
  function ShowTodaysWeather(response){

      let obj = JSON.parse(response);

      let weather = obj.weather[0].description;
      let city = obj.name;
      let minTemp = obj.main.temp_min;
      let maxTemp = obj.main.temp_max;
      let icon=obj.weather[0].icon;
      
      let iconUrl = "http://openweathermap.org/img/w/" + icon + ".png";
      $("#main-weather").attr("src",iconUrl);
      $("#min-temp1").text(minTemp);
      $("#max-temp1").text(maxTemp);


      console.log("現在の" + city + "の天気は" + weather);
      console.log("最低気温は" + minTemp + ",最高気温は"+maxTemp+"度です。");

}
    
})