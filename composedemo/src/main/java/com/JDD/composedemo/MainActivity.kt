package com.JDD.composedemo

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {


    private val messages: List<Message> = listOf(
        Message("A","Test...Test...Test"),
        Message("A","Test...Test...Test\nTest...Test...Test\nTest...Test...Test"),
        Message("A","Test...Test...Test"),
        Message("A","Test...Test...Test\nTest...Test...Test"),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContentView(R.layout.activity_main)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
        setContent {
//            Text("HELLO WORLD!!!")
//            MyCustomTheme{
//                Surface(modifier = Modifier.fillMaxSize()) {
//                    MessageCard(Message("Android","Jetpack Compose"))
//                }
//            }

            MyCustomTheme {
                Conversation(messages)
            }

        }
    }

    data class Message(val author: String,val body: String)

    @Composable
    fun MessageCard(msg: Message): Unit {
        Row(modifier = Modifier.padding(all = 8.dp)) {
            Image(
                painter = painterResource(id = R.drawable.panda),
                contentDescription = "panda surprise image.",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .border(1.5.dp, MaterialTheme.colorScheme.primary, CircleShape)
            )
            //Add a Horizontal space between the image and the column
            Spacer(modifier = Modifier.width(8.dp))

            //记录状态
            var isExpanded by remember {
                mutableStateOf(false)
            }
            //根据状态更改item背景色
            val surfaceColor by animateColorAsState(
                if (isExpanded) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface,
            )

            Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
//                Image(
//                    painter = painterResource(id = R.drawable.panda),
//                    contentDescription = "panda surprise image.",
//                    modifier = Modifier.size(10.dp)
//                )
//                Spacer(modifier = Modifier.height(4.dp))
                Text(text = msg.author,
                    color = MaterialTheme.colorScheme.secondary,
                    style = MaterialTheme.typography.titleSmall)
                Spacer(modifier = Modifier.height(1.dp))
                Surface(shape = MaterialTheme.shapes.medium,
                    shadowElevation = 1.dp,
                    //设置背景颜色
                    color = surfaceColor,
                    modifier = Modifier.animateContentSize().padding(1.dp)) {
                    Text(text = msg.body,
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.padding(4.dp),
                        // 保证不展开转态只有一行展示
                        maxLines = if (isExpanded) Int.MAX_VALUE else 1)
                }
            }
        }

    }

    @Preview(name = "Light Mode")
    @Preview(uiMode = Configuration.UI_MODE_NIGHT_YES,
        showBackground = true,
        name = "Dark Mode")
    @Composable
    fun PreviewMessageCard() { //专门用于预览的方法
        MyCustomTheme{
            Surface(modifier = Modifier.fillMaxSize()) {
                MessageCard(Message("JDD","Hey, take a look at Jetpack Compose, it's great!"))
            }
        }
    }

    @Composable
    fun Conversation(messages: List<Message>){
        LazyColumn {
            items(messages){message ->
                MessageCard(msg = message)
            }
        }
    }

    @Preview
    @Composable
    fun PreviewConversation(){
        MyCustomTheme {
            Conversation(messages)
        }
    }


}