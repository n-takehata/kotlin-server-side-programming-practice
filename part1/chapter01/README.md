# 概要
chapter01ディレクトリが、一つのGradleプロジェクトとなっています。  
IntelliJ IDEAで [File]->[Open] を選択し、このディレクトリのbuild.gradle.ktsを開いてください。  
ダイアログが表示されるので、[Open as Project] を選択してください。

src/main/kotlin配下のMain.ktに全てのサンプルコードが入っています。  
各コード上の書籍との対応は、以下のようにリスト番号をコメントで記載しています。

```
/**
 * リスト1.3.1
 */
```

# 実行方法
クラスの定義などを除く、実行結果の伴うサンプルコードは、リストごとに関数として処理を記述しています。  
一番上にあるmain関数を以下のように書き換え、実行したいリストの関数を呼び出す形に変更することで、動作確認をできます。

```
fun main() {
    list1_3_8()
}
```

# 補足
複数のリストで同じクラス名や関数名を使っている場合など、並べて書かれているとコンパイルエラーになってしまうものは、コメントアウトされています。  
必要に応じてコメントを外し、実行してください。  
コンパイルエラーになる例を紹介しているコードに関しても、同様にコメントアウトされています。
