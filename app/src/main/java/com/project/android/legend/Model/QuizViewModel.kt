package com.project.android.legend.Model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.project.android.legend.DataClass.Hero
import com.project.android.legend.DataClass.Question

class QuizViewModel : ViewModel(){

    val liveHero = MutableLiveData<List<Hero>>()
    private val heroQuestions = HeroQuestions()
    private val listHeroes = arrayListOf(
        Hero("Лейла", heroQuestions.questionsLayla, "0"),
        Hero("Заск", heroQuestions.questionsZask, "1"),
        Hero("Ван Ван", heroQuestions.questionsVanVan, "2"),
        Hero("Валир", heroQuestions.questionsValir, "3"),
        Hero("Беатрис", heroQuestions.questionsBeatris, "4"),
        Hero("Терзила", heroQuestions.questionsTerzila, "5"),
        Hero("Руби", heroQuestions.questionsRuby, "6"),
        Hero("Тигрил", heroQuestions.questionsTigril, "7"),
        Hero("Вейл", heroQuestions.questionsVail, "8"),
        Hero("Лилия", heroQuestions.questionsLiliya, "9"),
        Hero("Москов", heroQuestions.questionsMoscov, "10"),
        Hero("Мия", heroQuestions.questionsMiya, "11"),
        Hero("Горд", heroQuestions.questionsGord, "12"),
        Hero("Клауд", heroQuestions.questionsKlaud, "13"),
        Hero("Тамуз", heroQuestions.questionsTamuz, "14"),
        Hero("Роджер", heroQuestions.questionsRodjer, "15"),
        )


    private var questionBank = listOf(
        Question("Для начала викторины необходимо выбрать героя",true),
        Question("", true)
    )

    fun getHero(): ArrayList<Hero> {
        return listHeroes
    }

    var currentIndex = 0
    var questionIndex = -1
    var correctIndex = 0
    var inCorrectIndex = 0
    var cheatIndex = 0
    var showAnswer = false

    val currentQuestionAnswer: Boolean
        get() = questionBank[currentIndex].answer

    val currentQuestionText : String
        get() = questionBank[currentIndex].textResId

    fun moveToNext(){
        currentIndex = (currentIndex + 1) % questionBank.size
    }

    fun moveToPrev(){
        currentIndex = (currentIndex - 1) % questionBank.size
    }

    fun getQuestionBank() : List<Question>{
        return questionBank
    }

    fun setQuestionBank(list: List<Question>){
        questionBank = list
    }

    fun completed(){
        questionBank[currentIndex].completed=true
    }

    fun isCompleted(): Boolean{
        return questionBank[currentIndex].completed
    }

    fun cheatQuestion(){
        questionBank[currentIndex].cheat=true
    }

    fun isCheatQuestion(): Boolean{
        return questionBank[currentIndex].cheat
    }

    fun clearResult(){
         currentIndex = 0
         questionIndex = -1
         correctIndex = 0
         inCorrectIndex = 0
         cheatIndex = 0
         showAnswer = false
        for (question in questionBank){
            question.completed=false
        }
    }
    private class HeroQuestions(

        val questionsLayla: List<Question> = listOf(
            Question("Противниками Лейлы стали ученые из лабы 1718.", true),
            Question("Отец Лейлы один из членов ученых лабы 1718.", true),
            Question("Губительную пушку Лейле подарил её дед.", false),
            Question("Лейлу схватили учёные из лабы 1718, потому что она меткий стрелок.", false),
            Question("В похищении Лейлы виновата Губительная Пушка.", true),
            Question("Истинные причины поступка отца, Лейле рассказал дед.", true)
        ),

        val questionsZask: List<Question> = listOf(
            Question("Заск король Роя Кастии.", true),
            Question("Заклятый враг Роя Кастии - Митлора.", true),
            Question("Охотник из Митлоры уничтожил Рой Кастии.", false),
            Question("Кастия уцелела после нападения охотника из Милторы.", false),
            Question("Своё вторжения в Земли Рассвета, Заск начал с северной долины.", true),
            Question("Именно Авроре удалось сильно ранить Заска.", true)
        ),

        val questionsVanVan: List<Question> = listOf(
            Question("Иглы Ван Ван это наследие Людей Тана.", true),
            Question("Судьбу Ван Ван навсегда изменил Чёрный Дракон.", true),
            Question("Чёрный дракон долго и упорно обучал Ван Ван.", false),
            Question("Чёрный дракон учил Ван Ван в лесу.", false),
            Question("Ван Ван использует арбалет Тана только во время ультимейта.", true),
            Question("Пассивка Ван Ван это Шаг тигра.", true)
        ),

        val questionsValir: List<Question> = listOf(
            Question("Валир пять лет жил на вулкане.", true),
            Question("Горд был тем, кто остановил битву Валира и Вейла.", true),
            Question("Вейл хотел убить Валира.", false),
            Question("Горд помог Вейлу в бою с Валиром.", false),
            Question("Тело Валира было всё в ожогах.", true),
            Question("Сражение с Валиром разбудило вулкан.", true)
        ),

        val questionsBeatris: List<Question> = listOf(
            Question("Многие поколения семьи Беатрис были богатыми торговцами.", true),
            Question("Беатрис поражала своими способностям к науке в университете.", true),
            Question("Проект Беатрис называла Нексус:Выжить.", false),
            Question("Ученым из лабы 1718 не удалось взломать проект.", false),
            Question("Беатрис забрала контроль на серверами у сумасшедшего биохимика Октавиуса.", true),
            Question("Беатрис подарила свою терминальную систему «Выживание: Нексус» Союзу ученых.", true)
        ),

        val questionsTerzila: List<Question> = listOf(
            Question("Теризла был владельцев кузни.", true),
            Question("В крахе Теризлы виновата Империя.", true),
            Question("Над Теризлой проводили испытания ядами.", false),
            Question("Первые слова услышаные после освобождения «Сопротивляйся. " +
                    "Пусть ненависть распространиться и взорвёт всё на этой земле.", false),
            Question("Первый к кто заговорил с Теризлой была красивая девушка.", true),
            Question("Красивая девушка была ведьмой.", true)
        ),

        val questionsRuby: List<Question> = listOf(
            Question("Деревня девочки находилась глубоко в лесу.", true),
            Question("Когда волки пришли, Руби стояла на коленях на кровати.", true),
            Question("Она просила бога об отступлении волков.", false),
            Question("Волк по имени Рык убил бабушку и дедушку.", false),
            Question("Руба выжила прячась под трупами родных.", true),
            Question("Она в одиночку перебила всех волков косой, в живых остался только вожак.", true)
        ),

        val questionsTigril: List<Question> = listOf(
            Question("Тигрил — главнокомандующий Имперским отрядом Монийских Рыцарей.", true),
            Question("С юности Тигрил был верным сторонником Лорда Света.", true),
            Question("Тигрил был бесстрашным и спас всех своих наствиков.", false),
            Question("После возвращения домой тигрил стал более мягким.", false),
            Question("игрил постоянно искал самых смелых воинов, и, по его мнению," +
                    " нет никого лучше, чем Алукард.", true),
            Question("Каждый раз, когда он поднимается по ступенькам к Храму Света," +
                    " он делает это с сердцем, полным сожаления.", true)
        ),

        val questionsVail: List<Question> = listOf(
            Question("Вэил и Валир были лучшими друзьями. ", true),
            Question("Долгое время Валир и Вэйл были неразлучны," +
                    " оставив множества воспоминаний в Долине Ветров," +
                    " Огненном Королевстве и других невероятных местах.", true),
            Question("Когда беспорядки охватили Долину Ветров, Вэил исчез.", false),
            Question("Вэил был из семьи магов, кто умел менять ветер.", false),
            Question("В день договора он покажет всю невероятную силу магии ветра мальчику," +
                    " который был словно огонь.", true),
            Question("Вэйл верит, что, увидев его магию, Валир вспомнит те времена," +
                    " когда они были вместе.", true)
        ),

        val questionsLiliya: List<Question> = listOf(
            Question("Будучи потомками темных магов, Лилия обладает необычным характером" +
                    " и бесподобным магическим творчеством.", true),
            Question("Родители Лилии были высшими авторитетом среди темных магов и" +
                    " стояли у истоков создания академии.", true),
            Question("Лилия ненавидит своих родителей, за то что они " +
                    "оставили её одну.", false),
            Question("Сорн, чудовище, которое любит поглощать магию.", false),
            Question("Она хочет стать величайшим темным магом и встретиться со" +
                    " своими родителями.", true),
            Question("Сноры очень жадные существа.", true)
        ),

        val questionsMoscov: List<Question> = listOf(
            Question("Москов еще в юном возрасте, выступая на турнире Воина племен," +
                    " стал боевым мастером. ", true),
            Question("Он унаследовал фамильное оккультное боевое копье.", true),
            Question("Его все ненавидели и завидовали.", false),
            Question("Хан Хубилай хотел видеть Москва слудеющим главой клана", false),
            Question("Чтобы стать сильнее, Москов предпочел спуститься в Пропасть Теней" +
                    " и служить Королеве Смерти.", true),
            Question("С тех пор он стал известен как Копье Спокойствия.", true)
        ),

        val questionsMiya: List<Question> = listOf(
            Question("Валир пять лет жил на вулкане.", true),
            Question("Горд был тем, кто остановил битву Валира и Вейла.", true),
            Question("Вейл хотел убить Валира.", false),
            Question("Горд помог Вейлу в бою с Валиром.", false),
            Question("Тело Валира было всё в ожогах.", true),
            Question("Сражение с Валиром разбудило вулкан.", true)
    ),
        val questionsGord: List<Question> = listOf(
            Question("Валир пять лет жил на вулкане.", true),
            Question("Горд был тем, кто остановил битву Валира и Вейла.", true),
            Question("Вейл хотел убить Валира.", false),
            Question("Горд помог Вейлу в бою с Валиром.", false),
            Question("Тело Валира было всё в ожогах.", true),
            Question("Сражение с Валиром разбудило вулкан.", true)
        ),

        val questionsKlaud: List<Question> = listOf(
            Question("Валир пять лет жил на вулкане.", true),
            Question("Горд был тем, кто остановил битву Валира и Вейла.", true),
            Question("Вейл хотел убить Валира.", false),
            Question("Горд помог Вейлу в бою с Валиром.", false),
            Question("Тело Валира было всё в ожогах.", true),
            Question("Сражение с Валиром разбудило вулкан.", true)
        ),

        val questionsTamuz: List<Question> = listOf(
            Question("Валир пять лет жил на вулкане.", true),
            Question("Горд был тем, кто остановил битву Валира и Вейла.", true),
            Question("Вейл хотел убить Валира.", false),
            Question("Горд помог Вейлу в бою с Валиром.", false),
            Question("Тело Валира было всё в ожогах.", true),
            Question("Сражение с Валиром разбудило вулкан.", true)
        ),

        val questionsRodjer: List<Question> = listOf(
            Question("Валир пять лет жил на вулкане.", true),
            Question("Горд был тем, кто остановил битву Валира и Вейла.", true),
            Question("Вейл хотел убить Валира.", false),
            Question("Горд помог Вейлу в бою с Валиром.", false),
            Question("Тело Валира было всё в ожогах.", true),
            Question("Сражение с Валиром разбудило вулкан.", true)
        )
    )
}