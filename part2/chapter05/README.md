# 概要
「4 MyBatisでCRUDを作成する」までの内容がmybatis-onlyディレクトリ、「5 Spring BootからMyBatisを使用する」の内容がmybatis-with-springbootディレクトリに入っています。

mybatis-onlyはこのディレクトリ自体がGradleプロジェクトとなっています。  
databaseパッケージ配下にMybatis Generatorでの生成コードがあり、それ以外のサンプルコードは全てMain.ktに入っています。  
各コード上の書籍との対応は、以下のようにリスト番号をコメントで記載しています。

```
/**
 * リスト5.4.2
 */
```

また、src/main/resources配下に各種設定ファイルのサンプルコードも入っています。

mybatis-with-springbootはその下にdemoディレクトリがあり、こちらがSpring BootアプリケーションのGradleプロジェクトとなっています。  
内容は4章のdemoプロジェクトに、5章の「5 Spring BootからMyBatisを使用する」で作成した処理を加えたものになっています。

いずれもIntelliJ IDEAで [File]->[Open] を選択し、このディレクトリのbuild.gradle.ktsを開いてください。  
ダイアログが表示されるので、[Open as Project] を選択してください。

# 実行方法
## mybatis-only
クラスの定義などを除く、実行結果の伴うサンプルコードは、リストごとに関数として処理を記述しています。  
一番上にあるmain関数を以下のように書き換え、実行したいリストの関数を呼び出す形に変更することで、動作確認をできます。

```
fun main() {
    list5_4_4()
}
```

## mybatis-with-springboot/demo
以下の方法で実行できます。

- IntelliJ IDEAのGradleビューから、[Tasks]->[application]->[bootRun]を実行
- ターミナルでdemoディレクトリから ```./gradlew bootRun``` を実行
- DemoApplication.ktのmain関数を実行

# 補足
複数のリストで同じクラス名や関数名を使っている場合など、並べて書かれているとコンパイルエラーになってしまうものは、コメントアウトされています。  
必要に応じてコメントを外し、実行してください。  
コンパイルエラーになる例を紹介しているコードに関しても、同様にコメントアウトされています。
