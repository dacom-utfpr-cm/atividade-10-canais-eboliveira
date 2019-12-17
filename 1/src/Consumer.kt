import java.nio.ByteBuffer
import java.nio.channels.Pipe

class Consumer(private val pipe: Pipe, private val messageSize: Int) {
    private val source = pipe.source()
    private val buffer = ByteBuffer.allocate(messageSize)

    fun consume(){
        while(source.read(buffer) != 0){
            println(String(buffer.array(), Charsets.UTF_8))
            buffer.clear()
        }
    }
}