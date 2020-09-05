package org.ui.bootstrap

import org.ui.DraftComment
import org.ui.DraftNote
import org.ui.MediumSystem
import kotlin.random.Random

val titles = listOf("Tree With A Goal", "Changeling Of Water", "Pirates Without Hate", "Strangers Without Glory", "Serpents And Phantoms", "Heroes And Hunters", "Determination Of The Forsaken", "Hope Of The Stockades", "Battling At The Dark", "Question The West", "Horse Of Freedom", "Knight With Pride", "Women Of Time", "Mice Of Hell", "Soldiers And Criminals", "Horses And Boys", "End Of The Great", "Union Of Utopia", "Guarding The Void", "Remember The Fires", "Assassin With Pride", "Serpent Of Nightmares", "Defenders Without A Conscience", "Descendants Of The Ancestors", "Giants And Cats", "Traitors And Lords", "Family Of The Void", "Surprise Of The Stars", "Sounds In The Beginning", "Leading The Emperor", "Gangster Of Insanity", "Doctor Of The Gods", "Turtles Without Hope", "Heirs Of The South", "Humans And Children", "Traitors And Serpents", "Unity Of Sorrow", "Extinction Of Darkness", "Battling At My Nightmares", "Promises Of The Titans", "Criminal Of Despair", "God With A Goal", "Hunters Of The Gods", "Witches Of Dreams", "Rats And Fish", "Foreigners And Aliens", "Choice Without Hate", "Decay Of Darkness", "Death At The West", "Running In Myself", "Fish Of The Prison", "Warrior Of Dawn", "Soldiers Without A Conscience", "Humans Of The Sea", "Defenders And Wolves", "Soldiers And Friends", "Determination Of The Lost Ones", "Carnage Without Direction", "Songs Of The Mountains", "Arriving At The Town", "Slave Of Power", "Parrot Of The Forsaken", "Serpents Without Time", "Assassins Of Twilight", "Heroes And Lions", "Friends And Mice", "Vengeance Of The Land", "Union With Determination", "Temptations Of The World", "Ignoring The World", "Lord Of The Prison", "Stranger Of Dread", "Lions Of Fortune", "Knights Of Eternity", "Gangsters And Bandits", "Owls And Foes", "Confinement Of The Banished", "Demise With Pride", "Delaying The South", "Blinded In The Immortals", "Swindler With A Goal", "Man Of The West", "Fish Without Duty", "Humans Of The Stockades", "Phantoms And Horses", "Horses And Serpents", "Destiny Of Wind", "Spire Of The East", "Praise The Nation", "Raised By The East", "Hawk Of The Night", "Nymph With Gold", "Children Of Utopia", "Butchers Of The Eclipse", "Hunters And Butchers", "Witches And Spies", "Decay With Money", "Rise Of The Nation", "Praise The Depths", "Walking The Light")
val categories = listOf("Colors", "Verbs", "Astronomy", "Countries", "Directions", "English grammar", "Flora", "Geography", "Numbers", "homographs", "energy", "countries", "Green things", "Heteronyms", "Human body", "languages", "answers", "Opposites and synonyms", "materials", "Legal terms")
val body = "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of 'de Finibus Bonorum et Malorum' (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, 'Lorem ipsum dolor sit amet..', comes from a line in section 1.10.32.The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32 and 1.10.33 from 'de Finibus Bonorum et Malorum' by Cicero are also reproduced in their exact original form, accompanied by English versions from the 1914 translation by H. Rackham.There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable. The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc."
val comments = listOf<String>("But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of the great explorer of the truth, the master-builder of human happiness.",
    "No one rejects, dislikes, or avoids pleasure itself, because it is pleasure, but because those who do not know how to pursue pleasure rationally encounter consequences that are extremely painful.",
    "Nor again is there anyone who loves or pursues or desires to obtain pain of itself, because it is pain, but because occasionally circumstances occur in which toil and pain can procure him some great pleasure.",
    "To take a trivial example, which of us ever undertakes laborious physical exercise, except to obtain some advantage from it? But who has any right to find fault with a man who chooses to enjoy a pleasure that has no annoying consequences, or one who avoids a pain that produces no resultant pleasure?",
    "At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga.",
    "Et harum quidem rerum facilis est et expedita distinctio.",
    "Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis voluptas assumenda est, omnis dolor repellendus."
)
val random = Random(1001)

fun addAuthors(mediumSystem: MediumSystem) {
    mediumSystem.registerAuthor("jania","jania@gmail.com", "jania","https://robohash.org/eumutvoluptatem.jpg?size=50x50&set=set1")
    mediumSystem.registerAuthor("tiebold","tiebold@gmail.com", "tiebold","https://robohash.org/eumquoasperiores.png?size=50x50&set=set1")
    mediumSystem.registerAuthor("corella","corella@gmail.com", "corella","https://robohash.org/essedebitisneque.jpg?size=50x50&set=set1")
    mediumSystem.registerAuthor("curry","curry@gmail.com", "curry","https://robohash.org/quidempariaturquaerat.png?size=50x50&set=set1")
    mediumSystem.registerAuthor("berny","berny@gmail.com", "berny","https://robohash.org/sitquisat.png?size=50x50&set=set1")
    mediumSystem.registerAuthor("chip","chip@gmail.com", "chip","https://robohash.org/aconsequatureos.png?size=50x50&set=set1")
    mediumSystem.registerAuthor("sandie","sandie@gmail.com", "sandie","https://robohash.org/praesentiumvoluptatibuscommodi.jpg?size=50x50&set=set1")
    mediumSystem.registerAuthor("nye","nye@gmail.com", "nye","https://robohash.org/adipisciinillo.png?size=50x50&set=set1")
    mediumSystem.registerAuthor("tallia","tallia@gmail.com", "tallia","https://robohash.org/nonharumautem.png?size=50x50&set=set1")
    mediumSystem.registerAuthor("ashlen","ashlen@gmail.com", "ashlen","https://robohash.org/corruptimaximetotam.png?size=50x50&set=set1")
    mediumSystem.registerAuthor("woodman","woodman@gmail.com", "woodman","https://robohash.org/temporedolorumunde.bmp?size=50x50&set=set1")
    mediumSystem.registerAuthor("kacie","kacie@gmail.com", "kacie","https://robohash.org/veritatisiurevoluptatem.jpg?size=50x50&set=set1")
    mediumSystem.registerAuthor("des","des@gmail.com", "des","https://robohash.org/omnispossimusprovident.png?size=50x50&set=set1")
    mediumSystem.registerAuthor("adrienne","adrienne@gmail.com", "adrienne","https://robohash.org/facilisnobisdignissimos.png?size=50x50&set=set1")
    mediumSystem.registerAuthor("rebecka","rebecka@gmail.com", "rebecka","https://robohash.org/voluptatedoloremut.bmp?size=50x50&set=set1")
    mediumSystem.registerAuthor("emilia","emilia@gmail.com", "emilia","https://robohash.org/aperiaminmolestiae.bmp?size=50x50&set=set1")
    mediumSystem.registerAuthor("mallorie","mallorie@gmail.com", "mallorie","https://robohash.org/quiquasinihil.jpg?size=50x50&set=set1")
    mediumSystem.registerAuthor("octavia","octavia@gmail.com", "octavia","https://robohash.org/quidebitisquis.bmp?size=50x50&set=set1")
    mediumSystem.registerAuthor("palmer","palmer@gmail.com", "palmer","https://robohash.org/nemosequilaudantium.jpg?size=50x50&set=set1")
    mediumSystem.registerAuthor("nicko","nicko@gmail.com", "nicko","https://robohash.org/uttemporibusrerum.png?size=50x50&set=set1")
    mediumSystem.registerAuthor("a","a@gmail.com", "a","https://robohash.org/uttemporibusrerum.png?size=50x50&set=set1")
    mediumSystem.registerAuthor("b","b@gmail.com", "b","https://robohash.org/uttemporibusrerum.png?size=50x50&set=set1")
    mediumSystem.registerAuthor("c","c@gmail.com", "c","https://robohash.org/uttemporibusrerum.png?size=50x50&set=set1")
}

fun addNotes(mediumSystem: MediumSystem) {
    mediumSystem.authors.forEach { author ->
        val idNotes = List(10) { random.nextInt(0, 99)}.toSet().toList()
        idNotes.forEach {
            val categories = List(3) { categories[random.nextInt(0, 19)]}.toSet().joinToString()
            mediumSystem.addNote(author.id, DraftNote(titles[it], body, categories))
        }
    }
}

fun addComments(mediumSystem: MediumSystem) {
    mediumSystem.notes.forEach { note ->
        val idAuthors = List(7) { random.nextInt(1, mediumSystem.authors.size)}.toSet().toList()
        idAuthors.forEachIndexed {index, id ->
            mediumSystem.addComment(note.id, "a_$id", DraftComment(comments[index]))
        }
    }
}

fun getMediumSystem(): MediumSystem {
    val mediumSystem = MediumSystem()
    addAuthors(mediumSystem)
    addNotes(mediumSystem)
    addComments(mediumSystem)
    return mediumSystem
}
