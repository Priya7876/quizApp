package com.example.android.quizapp

object Constants{
    fun getQuestion():ArrayList<Question>{
        val questionLi=ArrayList<Question>()
        val q1=Question(1,"Who was the author of the famous storybook 'Alice's Adventures in Wonderland'?"
        ,"Rudyard Kipling","Keats","Lewis Carroll","H G Wells",3


        )
        questionLi.add(q1)
        val q2=Question(2,
        "Who wrote the famous 1855 poem 'The Charge of the Light Brigade'?",
            "Lord Alfred Tennyson","Christopher Marlowe","Christopher Marlowe"
,"René Descartes",1



            )
        questionLi.add(q2)
        val q3=Question(3,"Who wrote 'Where ignorance is bliss, it is folly to be wise'?"
        ,"Browning","Marx","Shakespeare","Kipling",3


        )
        questionLi.add(q3)
        val q4=Question(4,"Name the book which opens with the line 'All children, except one grew up'?",
        "The Railway Children",
            "Winnie the Poo",
"Jungle book",
        "Peter Pan",4

            )
        questionLi.add(q4)
        val q5=Question(5,
        "Which is the first Harry Potter book?",
            "HP and the Goblet of Fire",
            "HP and the Philosopher’s Stone",
            "HP and the Chamber of Secrets",
            "HP and the God of small Things",
            2


            )
        questionLi.add(q5)
        val q6=Question(6,"In which century were Geoffrey Chaucer's Canterbury Tales written?"
        ,
            "13th – 14th ",
            "14th – 15th",
            "15th -16th","4. 16th – 17th",1
        )
        questionLi.add(q6)
        val q7=Question(7,"What was the nationality of Robert Louis Stevenson, writer of 'Treasure Island'?"
,"Scottish",
            "Welsh",
            "Irish",
            "French"
,1

        )
        return questionLi
    }
}