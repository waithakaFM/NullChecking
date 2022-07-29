package rsk.kotlin

fun main(args: Array<String>) {
//    to enable null assignment we add ?
    val m: Meeting? = null

    var newMeeting = Meeting()

//    using elvis operator
    newMeeting = m ?: Meeting()

//    newMeeting = m
    closeMeeting(newMeeting)
    closeMeeting(m)

//    let calls if m not null
    m?.let {
        closeMeetingNonNull(m)
     }
}

fun closeMeetingNonNull(m: Meeting): Boolean? {
    return if (m.canClose) m.close()
    else false
}


fun closeMeeting(m: Meeting?): Boolean {
//    safe call
//    return if (m?.canClose == true) m?.close()
//    else false

//    assertion
    return if (m!!.canClose) m.close()
    else false
}

class Meeting {
    val canClose: Boolean = false

//    calling a class that I am yet to initialize -> make it late init variable
    lateinit var address: Address

    fun close(): Boolean{
        return true
    }

    fun save(o: Any){
//        safe cast -> if check is saveable is of type Isaveable if not it return null
        val saveable = o as? Isaveable
        saveable?.save()
    }
}

interface Isaveable{
    fun save()
}

class Address{

}