/**
 * 
 */
$(function() {
//	alert("OK");
//	
//	// マップのインスタンス生成
//	function initMap() {
//		var opts = {
//			zoom : 15, // 倍率
//			center : new google.maps.LatLng(35.709984, 139.810703)	// 初期表示の緯度経度設定
//		};
//
//		// #g-map要素にMapクラスの新しいインスタンスを作成
//		var map = new google.maps.Map(document.getElementById("g-map"), opts);
//
//		// 検索の条件を指定（緯度経度、半径、検索の分類）
//		var request = {
//			location : initPos,
//			radius : 1000, 	// 表示する半径領域を設定(1 = 1M)
//			types : [ 'cafe' ]	// typesプロパティの施設タイプを設定
//		};
//		
//		var service = new google.maps.places.PlacesService(map);
//		service.search(request, Result_Places);
//	}
//	
//	// 検索結果を受け取る
//	function Result_Places(results, status){
//	    // Placesが検索に成功したかをチェック
//	    if(status == google.maps.places.PlacesServiceStatus.OK) {
//	        for (var i = 0; i < results.length; i++) {
//	            // 検索結果の数だけ反復処理を変数placeに格納
//	            var place = results[i];
//	            createMarker({
//	                 text : place.name,
//	                 position : place.geometry.location
//	            });
//	        }
//	    }
//	}
//	
//	// 入力キーワードと表示範囲を設定
//	function SearchGo() {
//	    var initPos = new google.maps.LatLng(0,0);
//	    var mapOptions = {
//	        center : initPos,
//	        zoom: 0,
//	        mapTypeId : google.maps.MapTypeId.ROADMAP
//	    };
//	    
//	    // #g-map要素にMapクラスの新しいインスタンスを作成
//	    map = new google.maps.Map(document.getElementById("g-map"), mapOptions);
//	    service = new google.maps.places.PlacesService(myMap);
//	    
//	    // input要素に入力されたキーワードを検索の条件に設定
//	    var myword = document.getElementById("search");
//	    var request = {
//	        query : myword.value,
//	        radius : 5000,
//	        location : map.getCenter()
//	    };
//	    service.textSearch(request, result_search);
//	}
//	
//	// 検索の結果を受け取る
//	function result_search(results, status) {
//	    var bounds = new google.maps.LatLngBounds();
//	    for(var i = 0; i < results.length; i++){
//	        createMarker({
//	             position : results[i].geometry.location,
//	             text : results[i].name,
//	             map : map
//	         });
//	        bounds.extend(results[i].geometry.location);
//	    }
//	    map.fitBounds(bounds);
//	}
//	
//	// 該当する位置にマーカーを表示
//	function createMarker(options) {
//	    
//		// マップ情報を保持しているmyMapオブジェクトを指定
//	    options.map = map;
//	    
//	    // Markcrクラスのオブジェクトmarkerを作成
//	    var marker = new google.maps.Marker(options);
//	    
//	    // 各施設の吹き出し(情報ウインドウ)に表示させる処理
//	    var infoWnd = new google.maps.InfoWindow();
//	    infoWnd.setContent(options.text);
//
//	    // addListenerメソッドを使ってイベントリスナーを登録
//	    google.maps.event.addListener(marker, 'click', function(){
//	        infoWnd.open(map, marker);
//	    
//	    });
//	    
//	    return marker;
//	}
//	

});