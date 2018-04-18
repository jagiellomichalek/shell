package javatry.enjoy.ono;

// TODO yuto.imamura 不要なimportは削除しよう (2018/04/18)
import com.sun.org.apache.xpath.internal.operations.Bool;
import javatry.colorbox.ColorBox;
import javatry.colorbox.color.BoxColor;
import javatry.colorbox.space.BoxSpace;
import javatry.colorbox.unit.ColorBoxTestCase;

import java.util.*;
import java.lang.*;

/**
 * 文字列のテスト。<br>
 * 何々は？と言われたら、それに該当するものをログに出力すること。
 * @author ono
 */

// TODO [コメント] yuto.imamura [コメント] にも読んだら done ってつけてね (2018/04/18)
public class OnoQ0StringTest extends ColorBoxTestCase {

    // TODO yuto.imamura 即効push素晴らしい！！！
    // TODO yuto.imamura 早さも大事だけど、pushの前に一旦落ち着いて「本当にこれでよかったっけ？」って振り返ってみよう。
    // TODO あとログを出力する時は、第三者が見た時にもどんな値なのかを分かるように書いてみよう (2018/04/18)

    // ===================================================================================
    //                                                                            length()
    //                                                                            ========
    /**
     * 最初のカラーボックスの色の名前の文字数は？
     */
    public void test_length_basic() {
        List<ColorBox> colorBoxList = getColorBoxList();
        ColorBox colorBox = colorBoxList.get(0);
        BoxColor boxColor = colorBox.getColor();
        String colorName = boxColor.getColorName();
        log(colorName, colorName.length());
    }

    /**
     * カラーボックスに入ってる文字列の中で、一番長い文字列は？
     */
    // TODO yuto.imamura 一番長い「文字列」なので元々文字列の物で一番長い物を取り出そう！ (2018/04/18)
    public void test_length_findMax() {
        List<ColorBox> colorBoxList = getColorBoxList();
        String longestStr = "";
        for (ColorBox colorBox : colorBoxList) {
            for (BoxSpace boxSpace : colorBox.getSpaceList()) {
                Object object = boxSpace.getContents();
                String tempStr = "";

                try {
                    // TODO yuto.imamura 「toString()」すると元々文字列じゃない物（Integerとかdoubleとか）も文字列になっちゃう (2018/04/18)
                    tempStr = object.toString();
                } catch (Exception e) {
                    break;
                }
                if (tempStr.length() > longestStr.length()) {
                    longestStr = tempStr;
                }
            }
        }

        // TODO yuto.imamura 値だけじゃなくて第三者にも親切なログにしてみよう！ (2018/04/18)
        // TODO この値って何がどうなって出力された値？ (2018/04/18)
        log(longestStr);
    }

    /**
     * カラーボックスに入ってる文字列の中で、一番長いものと短いものの差は何文字？
     */
    public void test_length_findMaxMinDiff() {
        List<ColorBox> colorBoxList = getColorBoxList();
        String longestStr = "";
        String shortestStr = "";
        for (ColorBox colorBox : colorBoxList) {
            for (BoxSpace boxSpace : colorBox.getSpaceList()) {
                Object object = boxSpace.getContents();
                String tempStr = "";

                try {
                    // TODO yuto.imamura 上に同じく、「toString()」しちゃうと数字も文字列になっちゃうけど、それって元々カラーボックスに入っていた文字列かな？ (2018/04/18)
                    tempStr = object.toString();
                } catch (Exception e) {
                    break;
                }
                if (tempStr.length() > longestStr.length()) {
                    longestStr = tempStr;
                } else if (tempStr.length() < shortestStr.length()) {
                    shortestStr = tempStr;
                }
            }
        }

        // TODO yuto.imamura 上に同じく、これは何を表すログ？ (2018/04/18)
        log(longestStr.length() - shortestStr.length());
    }

    /**
     * カラーボックスに入ってる値 (文字列以外のものはtoString()) の中で、二番目に長い文字列は？ <br>
     * ソートして二番目を取得する、ってやり方で。
     */
    public void test_length_findSecondMax_bySort() {
        List<ColorBox> colorBoxList = getColorBoxList();
        //文字列の配列を作成
        List<String> strList = new ArrayList<String>();
        for (ColorBox colorBox : colorBoxList) {
            for (BoxSpace boxSpace : colorBox.getSpaceList()) {
                Object object = boxSpace.getContents();
                // TODO yuto.imamura 使われていない変数は無駄なので削除しよう！必要になった時に変数宣言しよう (2018/04/18)
                String tempStr = "";
                try {
                    // TODO [コメント] yuto.imamura これはtoString()でOK（問題文にあるため） (2018/04/18)
                    strList.add(object.toString());
                } catch (Exception e) {
                    break;
                }

            }
        }

        //Listをソート
        boolean isEnd = false;
        while (!isEnd) {
            boolean loopSwap = false;
            for (int i = 0; i < strList.size() - 1; i++) {
                if (strList.get(i).length() > strList.get(i+1).length()) {
                    String tempStr = strList.get(i+1);
                    strList.set(i+1, strList.get(i));
                    strList.set(i, tempStr);
                    loopSwap = true;
                }
            }
            if (!loopSwap) {
                isEnd = true;
            }
        }
        log(strList.get(1));
    }

    /**
     * カラーボックスに入ってる値 (文字列以外のものはtoString()) の中で、二番目に長い文字列は？ <br>
     * ただし、ソートして二番目を取得する、ってやり方は利用しないこと。
     */
    public void test_length_findSecondMax_nonSorted() {
    }

    /**
     * カラーボックスに入ってる文字列の長さの合計は？
     */
    public void test_length_calculateLengthSum() {
    }

    // ===================================================================================
    //                                                            startsWith(), endsWith()
    //                                                            ========================
    /**
     * 「かまくら」で始まる文字列をしまっているカラーボックスの色は？
     */
    public void test_startsWith_findFirstWord() {
    }

    /**
     * 「いぬ」で終わる文字列をしまっているカラーボックスの色は？
     */
    public void test_endsWith_findLastWord() {
    }

    // ===================================================================================
    //                                                            indexOf(), lastIndexOf()
    //                                                            ========================
    /**
     * あなたのカラーボックスに入ってる「いぬ」で終わる文字列で、「いぬ」は何文字目から始まる？
     */
    public void test_indexOf_findIndex() {
    }

    /**
     * あなたのカラーボックスに入ってる「ず」を二つ以上含む文字列で、最後の「ず」は何文字目から始まる？
     */
    public void test_lastIndexOf_findIndex() {
    }

    // ===================================================================================
    //                                                                         substring()
    //                                                                         ===========
    /**
     * カラーボックスに入ってる「いぬ」で終わる文字列の最初の一文字は？
     */
    public void test_substring_findFirstChar() {
    }

    /**
     * カラーボックスに入ってる「かまくら」で始まる文字列の最後の一文字は？
     */
    public void test_substring_findLastChar() {
    }

    // ===================================================================================
    //                                                                           replace()
    //                                                                           =========
    /**
     * カラーボックスに入ってる「ー」を含んだ文字列から「ー」を全て除去したら何文字？
     */
    public void test_replace_removeBo() {
    }

    // ===================================================================================
    //                                                                           Good Luck
    //                                                                           =========
    /**
     * カラーボックスの中で、色の名前が一番長いものは？
     */
    public void test_findMaxColorSize() throws Exception {
    }

    /**
     * カラーボックスの中で、2012/06/04 を示す日付が持っている秒は？
     */
    public void test_findDBFluteBirthdateSecond() throws Exception {
    }

    /**
     * カラーボックスの中に入っている Map を "map:{ key = value ; key = value ; ... }" という形式で表示。
     */
    public void test_showMap() throws Exception {
    }

    /**
     * "map:{ key1 = value1 ; key2 = value2 ; key3 = value3 }" という文字列をMapに変換してtoString()すると？
     * <pre>
     * 変換後のMapの中身は、以下のようになっていること
     *  o key1というキーに対してvalue1という値
     *  o key2というキーに対してvalue2という値
     *  o key3というキーに対してvalue3という値
     * </pre>
     */
    public void test_parseMap() throws Exception {
    }

    /**
     * "map:{ key1 = value1 ; key2 = map:{ nkey21 = nvalue21 ; nkey22 = nvalue22 } ; key3 = value3 }" <br />
     * という文字列をMapに変換してtoString()すると？ <br />
     * <br />
     * "map:{ key1 = value1 ; key2 = value2 ; key3 = map:{ nkey31 = nvalue31 ; nkey32 = nvalue32 } }" <br />
     * でも、同じプログラムでMapに変換できるようにするべし。
     */
    public void test_parseMap_deep() throws Exception {
    }
}
