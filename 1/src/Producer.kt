import java.nio.ByteBuffer
import java.nio.channels.Pipe

class Producer(private val pipe: Pipe, private val messageSize: Int ) {
    private val sink = pipe.sink()
    private val buffer = ByteBuffer.allocate(messageSize)

    fun produce(message: String){

        buffer.clear()
        buffer.put(message.toByteArray(Charsets.UTF_8))
        buffer.flip()

        while(buffer.hasRemaining()){
            sink.write(buffer)
        }
    }
}