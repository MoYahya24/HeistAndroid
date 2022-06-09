package com.example.HeistAndroid

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize


@Composable
fun DashboardFocus(name: String) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF000000))
    ) {

        Row( horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
            .fillMaxWidth()
            .padding(top = 40.dp, bottom = 100.dp, start = 15.dp, end = 15.dp)) {

            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back", tint= Color(0xFFFFFFFF), modifier = Modifier.size(40.dp))
            }

            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Home, contentDescription = "Back", tint= Color(0xFFFFFFFF), modifier = Modifier.size(40.dp))
            }

        }

        Text(
            text = "Welcome, " + name,
            color = Color(0xFFFFFFFF),
            fontSize = MaterialTheme.typography.h3.fontSize,
            fontWeight = FontWeight.ExtraBold
        )
        
        Card( modifier = Modifier
            .fillMaxSize()
            .padding(top = 70.dp), backgroundColor = Color(0xFF101010)) {
            Column(Modifier.fillMaxSize()) {
                Text(
                    text = "How It Works",
                    color = Color(0xFFFFFFFF),
                    fontSize = MaterialTheme.typography.h5.fontSize,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier.padding(top = 60.dp, start= 25.dp)
                )

                Text(
                    text = "To get started, you need to have an account. You can use an account you already have with a bank we partner with, or you can open an new account.",
                    color = Color(0xFFFFFFFF),
                    fontSize = MaterialTheme.typography.h6.fontSize,
                    fontWeight = FontWeight.ExtraLight,
                    modifier = Modifier.padding( start= 25.dp, top = 30.dp)
                )
                
                Button(onClick = {

                },
                    Modifier
                        .padding(start = 25.dp, top = 30.dp)
                        .border(width = 2.dp, color = Color(0xFFFFFFFF), shape = RectangleShape)) {
                    Text(text ="CONNECT AN ACCOUNT", fontWeight = FontWeight.ExtraBold )
                }
                Button(onClick = { /*TODO*/ },
                    Modifier
                        .padding(start = 25.dp, top = 30.dp)
                        .border(width = 2.dp, color = Color(0xFFFFFFFF), shape = RectangleShape)) {
                    Text(text ="OPEN AN ACCOUNT", fontWeight = FontWeight.ExtraBold )
                }
            }



        }
        
    }
}


@Composable
fun ConnectBank() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF000000))
    ) {
        Text(
            text = "Connect your bank",
            color = Color(0xFFFFFFFF),
            fontSize = MaterialTheme.typography.h4.fontSize,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.padding(start = 20.dp, top = 132.dp)
        )
        Card(
            modifier = Modifier
                //.fillMaxSize()
                .padding(top = 20.dp), backgroundColor = Color(0xFF101010)
        ) {
            Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {
                val banks= listOf<String>("CommonWealth","WestPac","ANZ","NAB")
                BankSpinner(banks = banks)
                Row(horizontalArrangement = Arrangement.End, modifier = Modifier
                    .background(Color(0xFF000000))
                    .fillMaxWidth()
                    //.padding(top = 40.dp, bottom = 100.dp, start = 15.dp, end = 15.dp)
                )
                {
                    Button(onClick = {  },
                        Modifier
                            .padding(bottom = 30.dp, top = 30.dp, end = 30.dp)) {
                        Text(text ="CANCEL", fontWeight = FontWeight.ExtraBold , fontSize = 16.sp)
                    }

                    Button(onClick = {  },
                        Modifier
                            .padding(bottom = 30.dp, top = 30.dp, end = 30.dp)
                            .border(width = 2.dp, color = Color(0xFFFFFFFF), shape = RectangleShape)) {
                        Text(text ="CHOOSE YOUR BANK", fontWeight = FontWeight.ExtraBold , fontSize = 16.sp)
                    }
                }
            }

        }



    }
}

@Composable
private fun BankSpinner(banks: List<String>){
    var rowSize by remember { mutableStateOf(androidx.compose.ui.geometry.Size.Zero) }
    var bankText by remember { mutableStateOf("Choose a bank")}
    var expanded by remember { mutableStateOf(false)}
    Row( modifier = Modifier
        .fillMaxWidth()
        .padding(20.dp)
        .background(Color(0xFF4F4F4F))
        .clickable { expanded = !expanded }
        .padding(bottom = 10.dp)
        .onGloballyPositioned { layoutCoordinates ->
            rowSize = layoutCoordinates.size.toSize()
        },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
        ){
        Text(text = bankText, modifier = Modifier.padding(8.dp), fontSize = 20.sp)
        Icon(imageVector = Icons.Filled.ArrowDropDown, contentDescription = "",  Modifier.background(Color(0xFF4F4F4F)))
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded=false },
            Modifier
                .width(with(LocalDensity.current) { rowSize.width.toDp() })
                .fillMaxWidth()
                .background(Color(0xFF222222))) {
            banks.forEach{
                bank -> DropdownMenuItem(modifier = Modifier.padding(10.dp), onClick = {
                    expanded=false
                    bankText=bank.toString()
            }) {
                Text(text = bank.toString())
            }
            }
        }
    }
}

@Composable
fun OpenAccount1(){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color(0xFF000000))
    ) {
        Text(
            text = "Where would you like to open an account?",
            color = Color(0xFFFFFFFF),
            fontSize = MaterialTheme.typography.h4.fontSize,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.padding(start = 20.dp, top = 132.dp)
        )
        Card(modifier = Modifier
            .fillMaxSize()
            .padding(top = 20.dp), backgroundColor = Color(0xFF101010)
        ) {
            Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {
                Column(Modifier.wrapContentSize()) {
                    Text(
                        text = "Bank name",
                        color = Color(0xFFFFFFFF),
                        fontSize = MaterialTheme.typography.h6.fontSize,
                        fontWeight = FontWeight.ExtraBold,
                        modifier = Modifier.padding(start = 20.dp, top = 20.dp)
                    )
                    val banks= listOf<String>("CommonWealth","WestPac","ANZ","NAB")
                    BankSpinner(banks = banks)
                }

                Row(horizontalArrangement = Arrangement.End, modifier = Modifier
                    .background(Color(0xFF000000))
                    .fillMaxWidth()
                    //.padding(top = 40.dp, bottom = 100.dp, start = 15.dp, end = 15.dp)
                )
                {
                    Button(onClick = {  },
                        Modifier
                            .padding(bottom = 30.dp, top = 30.dp, end = 20.dp)) {
                        Text(text ="CANCEL", fontWeight = FontWeight.ExtraBold , fontSize = 16.sp)
                    }

                    Button(onClick = {  },
                        Modifier
                            .wrapContentWidth()
                            .padding(bottom = 30.dp, top = 30.dp, end = 2.dp)
                            .border(width = 2.dp, color = Color(0xFFFFFFFF), shape = RectangleShape)) {
                        Text(text ="GO TO PERSONAL DETAILS", fontWeight = FontWeight.ExtraBold , fontSize = 16.sp)
                    }
                }


            }
        }
    }
}

@Composable
fun OpenAccount2(){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color(0xFF000000))
    ) {
        Text(
            text = "Confirm your personal details to use for your new account",
            color = Color(0xFFFFFFFF),
            fontSize = MaterialTheme.typography.h4.fontSize,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.padding(start = 20.dp, top = 132.dp)
        )
        Card(modifier = Modifier
            .fillMaxSize()
            .padding(top = 20.dp), backgroundColor = Color(0xFF101010)
        ) {
            Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {
                Column(Modifier.wrapContentSize()) {

                    var name by remember { mutableStateOf("")}
                    OutlinedTextField(value = name, onValueChange = { newName->
                        name = newName
                        if (newName.length <= 20) name = newName
                    },
                    label = {
                        Text(text = "Full name", color = Color(0xFFFFFFFF))
                    },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color(0xFFFFFFFF),
                            unfocusedBorderColor = Color(0xFFFFFFFF)),
                        leadingIcon = {
                            Icon(imageVector = Icons.Outlined.Person, contentDescription = "", tint= Color(0xFFFFFFFF))
                        }, modifier = Modifier.padding(start=20.dp, top=20.dp)
                    )
                    var address by remember { mutableStateOf("")}
                    OutlinedTextField(value = address, onValueChange = { newAdd->
                        address = newAdd
                    },
                        label = {
                            Text(text = "Address", color = Color(0xFFFFFFFF))
                        },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color(0xFFFFFFFF),
                            unfocusedBorderColor = Color(0xFFFFFFFF)),
                        leadingIcon = {
                            Icon(imageVector = Icons.Outlined.Home, contentDescription = "", tint= Color(0xFFFFFFFF))
                        }, modifier = Modifier.padding(start=20.dp, top=20.dp)
                    )
                    var phone by remember { mutableStateOf("")}
                    OutlinedTextField(value = phone, onValueChange = { newPhone->
                        phone = newPhone
                    },
                        label = {
                            Text(text = "Address", color = Color(0xFFFFFFFF))
                        },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color(0xFFFFFFFF),
                            unfocusedBorderColor = Color(0xFFFFFFFF)),
                        leadingIcon = {
                            Icon(imageVector = Icons.Outlined.Phone, contentDescription = "", tint= Color(0xFFFFFFFF))
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Phone
                        ), modifier = Modifier.padding(start=20.dp, top=20.dp)
                    )
                }

                Row(horizontalArrangement = Arrangement.End, modifier = Modifier
                    .background(Color(0xFF000000))
                    .fillMaxWidth()
                    //.padding(top = 40.dp, bottom = 100.dp, start = 15.dp, end = 15.dp)
                )
                {
                    Button(onClick = {  },
                        Modifier
                            .padding(bottom = 30.dp, top = 30.dp, end = 20.dp)) {
                        Text(text ="CANCEL", fontWeight = FontWeight.ExtraBold , fontSize = 16.sp)
                    }

                    Button(onClick = {  },
                        Modifier
                            .wrapContentWidth()
                            .padding(bottom = 30.dp, top = 30.dp, end = 2.dp)
                            .border(width = 2.dp, color = Color(0xFFFFFFFF), shape = RectangleShape)) {
                        Text(text ="GO TO ACCOUNT TYPE", fontWeight = FontWeight.ExtraBold , fontSize = 16.sp)
                    }
                }


            }
        }
    }
}

@Composable
fun OpenAccount3(){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color(0xFF000000))
    ) {
        Text(
            text = "Choose the kind of account you would like to open",
            color = Color(0xFFFFFFFF),
            fontSize = MaterialTheme.typography.h4.fontSize,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.padding(start = 20.dp, top = 132.dp)
        )
        Card(modifier = Modifier
            .fillMaxSize()
            .padding(top = 20.dp), backgroundColor = Color(0xFF101010)
        ) {
            Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {
                Column(Modifier.wrapContentSize()) {
                    val list= listOf<String>("Checkings","Savings")
                    val states = remember { mutableStateListOf(false, false)}
                    GroupedCheckbox(list = list, states = states)


                }

                Row(horizontalArrangement = Arrangement.End, modifier = Modifier
                    .background(Color(0xFF000000))
                    .fillMaxWidth()
                    //.padding(top = 40.dp, bottom = 100.dp, start = 15.dp, end = 15.dp)
                )
                {
                    Button(onClick = {  },
                        Modifier
                            .padding(bottom = 30.dp, top = 30.dp, end = 20.dp)) {
                        Text(text ="CANCEL", fontWeight = FontWeight.ExtraBold , fontSize = 16.sp)
                    }

                    Button(onClick = {  },
                        Modifier
                            .wrapContentWidth()
                            .padding(bottom = 30.dp, top = 30.dp, end = 2.dp)
                            .border(width = 2.dp, color = Color(0xFFFFFFFF), shape = RectangleShape)) {
                        Text(text ="CONFIRM", fontWeight = FontWeight.ExtraBold , fontSize = 16.sp)
                    }
                }


            }
        }
    }
}
@Composable
fun GroupedCheckbox(
    list: List<String>,
    states: MutableList<Boolean>
){
    Column() {
        list.forEachIndexed{index, item->
            Row (verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(start=20.dp, top=20.dp)){
                Checkbox(checked = states[index],
                    onCheckedChange = {states[index]=it},
                    modifier = Modifier.scale(2F),
                    colors = CheckboxDefaults.colors(
                        checkmarkColor = Color(0xFF000000),
                        uncheckedColor = Color(0xFFFFFFFF),
                        checkedColor = Color(0xFFFFFFFF)
                    )
                    )
                Text(text = item, modifier = Modifier.padding(start = 10.dp), fontWeight = FontWeight.ExtraBold, fontSize = MaterialTheme.typography.h6.fontSize,)
            }
            

        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePagePreview(){
    OpenAccount1()
}