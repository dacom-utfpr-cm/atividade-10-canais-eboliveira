import java.nio.channels.Pipe
import kotlin.random.Random

fun main() {
    val pipe = Pipe.open()
    val consumer = Consumer(pipe, 128)
    val producer = Producer(pipe, 128)


    Thread {
        while(true){
            producer.produce("Ola")
            Thread.sleep(Random.nextLong(4000))
        }
    }.start()

    consumer.consume()
}