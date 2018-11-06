# FlickerSearchAPI

# 概要 
Flicker画像検索アプリを作成します。

# 条件
    Flickr APIを利用して写真が検索できていること
    APIで取得した情報をもとに、写真をサーバーから取得できていること
    1リクエスト当たりの取得件数を50件とすること(1リクエスト当たりの制限事項）
    50件以上データが存在する場合に、ページングして取得できていること（ページング処理）
    検索結果が0件の場合、「該当する写真がありません。検索ワードを変更してお試しください。」と画面に表示されること
    オフラインの場合、「ネットワーク環境の良い環境で再度お試しください。」と画面に表示されること
    アプリの画面は、検索用の入力フィールド（プレースホルダー:キーワードを入力してください）と検索結果をグリッド形式又はリスト形式で表示すること
    検索用の入力フィールドが未入力のときは、検索ボタンが押せないものとする（非活性）
    
    
    
    
# APIの概要

http://westplain.sakuraweb.com/translate/flickr/read/Overview.cgi http://westplain.sakuraweb.com/translate/flickr/requestFormats/REST.cgi http://westplain.sakuraweb.com/translate/flickr/responseFormats/JSON.cgi http://westplain.sakuraweb.com/translate/flickr/APIMethods/photos/search.cgi
