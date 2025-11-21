import react.dom.createRoot
import react.dom.html.ReactHTML.div
import react.FC
import emotion.react.css

val App = FC {
    div {
        css {
            color = kotlinx.css.Color.red
            fontSize = kotlinx.css.em(1.5)
        }
        +"Hello Kotlin/JS React with Emotion!"
    }
}

fun main() {
    val container = kotlinx.browser.document.getElementById("root")!!
    createRoot(container).render(App.create())
}
