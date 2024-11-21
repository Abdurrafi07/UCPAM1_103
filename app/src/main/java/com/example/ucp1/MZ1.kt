package com.example.ucp1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun MZ1(modifier: Modifier = Modifier){
    Column(modifier = modifier.fillMaxSize()) {
        HeaderSection()
        var dari by remember { mutableStateOf("") }
        var tujuan by remember { mutableStateOf("") }
        var pergi by remember { mutableStateOf("") }
        var kedatangan by remember { mutableStateOf("") }
        var kelas by remember { mutableStateOf("") }

        var dataKelas = listOf("Ekonomi", "Bussiness")

        var confDari by remember { mutableStateOf("") }
        var confTujuan by remember { mutableStateOf("") }
        var confPergi by remember { mutableStateOf("") }
        var confKedatangan by remember { mutableStateOf("") }
        var confKelas by remember { mutableStateOf("") }

        Column(
            modifier = modifier.fillMaxSize().padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                value = dari,
                onValueChange = { dari = it },
                label = {
                    Text(text = "Dari")
                },
                placeholder = {
                    Text(text = "Dari")
                },
                modifier = Modifier.fillMaxWidth().padding(5.dp)
            )
            TextField(
                value = tujuan,
                onValueChange = { tujuan = it },
                label = {
                    Text(text = "Ke")
                },
                placeholder = {
                    Text(text = "Tujuan")
                },
                modifier = Modifier.fillMaxWidth().padding(5.dp)
            )
            Row(
                modifier = Modifier.fillMaxWidth().padding(5.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                TextField(
                    value = pergi,
                    onValueChange = { pergi = it },
                    label = {
                        Text(text = "Keberangkatan")
                    },
                    placeholder = {
                        Text(text = "Tanggal Berangkat")
                    },
                    modifier = Modifier.weight(1f)
                )

                TextField(
                    value = kedatangan,
                    onValueChange = { kedatangan = it },
                    label = {
                        Text(text = "Kedatangan")
                    },
                    placeholder = {
                        Text(text = "Tanggal Kedatanagan")
                    },
                    modifier = Modifier.weight(1f)
                )
            }
            Row(modifier = Modifier.fillMaxWidth()) {
                dataKelas.forEach { selectedGender ->
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(
                            selected = kelas == selectedGender,
                            onClick = { kelas = selectedGender }
                        )
                        Text(text = selectedGender)
                    }
                }
            }
            Button(onClick = {
                confDari = dari
                confTujuan = tujuan
                confPergi = pergi
                confKedatangan = kedatangan
                confKelas = kelas
            },modifier.fillMaxWidth() ) {
                Text(text = "Submit")
            }

            Text(text = "Detail Data")

            TampilData(
                Param = "Keberangkatan",
                Argu = confPergi)
            TampilData(
                Param = "",
                Argu = confDari)
            TampilData(
                Param = "",
                Argu = confKedatangan)
            TampilData(
                Param = "Kedatangan",
                Argu = confPergi)
            TampilData(
                Param = "",
                Argu = confTujuan)
            TampilData(
                Param = "",
                Argu = confKedatangan)
        }
    }
}

@Composable
fun HeaderSection() {
    Box(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(text = "Good Afternoon,")
                Text(
                    text = "Abdurrafi Nur Fakhruddin",
                    style = TextStyle(fontWeight = FontWeight.Bold)
                )
            }

            Icon(
                imageVector = Icons.Default.Notifications, // Replace with desired icon
                contentDescription = "Profile Icon",
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Composable
fun TampilData(Param : String, Argu : String){
    Column(modifier = Modifier.padding(16.dp)) {
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = Param, modifier = Modifier.weight(0.9f))
            Text(text = ": ", modifier = Modifier.weight(0.2f))
            Text(text = Argu, modifier = Modifier.weight(2f))
        }
    }
}