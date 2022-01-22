# Javaで学ぶDesign Pattern--結城浩
## Iterator
- 数え上げ
## Adaptor
- 変換
- Wrapperとも
- クラスによるAdaptorパターン(継承)
  - 適合させられる側を継承する
  - 継承した子クラスで、親クラスのメソッドを呼び出す
  - 継承した子クラスは、規定されたintefaceを実装している
- インスタンスによるAdaptorパターン(委譲)
  - 適合させられる側を、クラスフィールドに持つ。コンストラクタで持つ
  - 初期化する際に、コンストラクタからフィールドに設定する
  - フィールドからメソッドを持つ
 
## Tempalate method
- スーパークラスで処理の枠組みを定め、サブクラスでその具体的内容を決める
- comment
  - 統一的にできるのがメリットかもしれない
  - 例えば、エラーの返し方などを統一的にしたいときにテンプレートメソッドパターンを用いると、プログラム全体で統一的な返し方ができる
## Factory method
- 以下の特徴を、インスタンス生成の時に応用したもの
  - Template methodのスーパークラスで骨組み、サブクラスで処理の具体化
##  Singleton
- インスタンスがだた一つであることを保証する
- Threadと絡めて理解できるようにしたい

## prototype
- インスタンス化する代わりに、コピーしてインスタンスを作成する
1. 種類が多すぎてクラスにまとめられない
2. クラスからのインスタンス生成が難しい
3. フレームワークと生成するインスタンスを分ける

## builder
- Director
  - Builderを利用してインスタンスを生成
- Builder
  - インスタンスを作成するためのインターフェイスを定める
- ConcreteBuilder
  - Builderを実装している
## abstract factory
- 具体には注目せずに、インターフェイスにだけ着目してプログラムを作る
## bridge
- 機能のクラスと実装のクラスを橋渡しする

## strategy
- 戦略・アルゴリズムを置き換える

## composite
- 容器と中身を同一視して、再帰的な構造を作る
- 容器と中身をそのひとつ上のレイヤーで捉える

## decorator
- 中心となるオブジェクトに飾りをつけていく

## vitor
- データ構造と処理を分離
- データ構造を中を移動する訪問書を表す区rすを準備して、そのクラスに処理を任せる
- 新しい機能を追加したい時には、その訪問者を新しく作るようにする

## Chain of repository
- 複数のオブジェクトを繋いでおき、そのオブジェクトの鎖を順次渡り歩いて、目的のオブジェクトを決定すること
- その処理を決定するオブジェクトを一つに決められれない場合に用いる
- 要求する側のと処理する側の結びつきを弱めることができる

## facade
- これべるのインターフェースを提供する。システムの内側に対しては、役割や依存関係を考えて、正しい順番でクラスを利用する