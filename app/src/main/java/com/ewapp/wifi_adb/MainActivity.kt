package com.ewapp.wifi_adb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.ewapp.wifi_adb.ui.theme.WiFiADBTheme


// 应用的主页面
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WiFiADBTheme {
                // 使用Scaffold构建应用结构
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // 渲染Greeting函数
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

// 问候组件
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    // 创建一个状态变量来存储TextField的值
    var text by remember { mutableStateOf("") }

    // 使用Column布局组织Text与TextField
    Column(modifier = modifier) {
        // 显示问候消息
        Text(
            text = "Hello $name!",
            modifier = modifier.padding(bottom = 8.dp)
        )
        // 创建可以输入文本的TextField
        TextField(
            value = text,
            onValueChange = { newText ->
                text = newText
            },
            label = { Text("Enter something...") }
        )
    }
}

// 在预览中显示Greeting组件
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WiFiADBTheme {
        Greeting("Android")
    }
}