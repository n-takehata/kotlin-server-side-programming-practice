# 概要
「2 gRPCの導入」までの内容がgrpc-onlyディレクトリ、「3 Spring BootでgRPCのKotlinサーバーサイドプログラムを実装」の内容がgrpc-with-springbootディレクトリに入っています。

それぞれのディレクトリでGradleプロジェクトとなっています。  
いずれもIntelliJ IDEAで [File]->[Open] を選択し、このディレクトリのbuild.gradle.ktsを開いてください。  
ダイアログが表示されるので、[Open as Project] を選択してください。

# 実行方法
## grpc-only
GreeterServer.ktのmain関数を実行してサーバーを起動し、GreeterClient.ktのmain関数を実行します。

## grpc-with-springboot
以下の方法で実行できます。

- IntelliJ IDEAのGradleビューから、[Tasks]->[application]->[bootRun]を実行
- ターミナルでdemoディレクトリから ```./gradlew bootRun``` を実行
- Application.ktのmain関数を実行

# 補足
複数のリストで同じクラス名や関数名を使っている場合など、並べて書かれているとコンパイルエラーになってしまうものは、コメントアウトされています。  
必要に応じてコメントを外し、実行してください。  
コンパイルエラーになる例を紹介しているコードに関しても、同様にコメントアウトされています。
