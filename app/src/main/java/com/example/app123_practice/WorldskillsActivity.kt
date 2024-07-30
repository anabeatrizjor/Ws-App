package com.example.app123_practice

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class WorldskillsActivity : AppCompatActivity() {

    // spinner
    private lateinit var spinner: Spinner
    private lateinit var imageView: ImageView
    private lateinit var textView: TextView

    // menu
    private lateinit var drawerLayout: DrawerLayout

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_worldskills)

        // menu

        drawerLayout = findViewById(R.id.mainW)
        val navView = findViewById<NavigationView>(R.id.navViewWs)
        val menu = findViewById<ImageView>(R.id.menuWs)

        // spinner

        spinner = findViewById(R.id.spinnerWs)
        imageView = findViewById(R.id.imageViewSpinner)
        textView = findViewById(R.id.textViewSpinner)

        // LÓGICA MENU
        // menu lógica
        menu.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        navView.setNavigationItemSelectedListener { menuItem ->
            menuItem.isChecked = true
            drawerLayout.closeDrawers()

            when (menuItem.itemId) {
                R.id.homeMain -> {
                    startActivity(Intent(this@WorldskillsActivity, MainActivity::class.java))
                }
                R.id.configPage -> {
                    startActivity(Intent(this@WorldskillsActivity, SettingsActivity::class.java))
                }
                R.id.contatoPage -> {
                    startActivity(Intent(this@WorldskillsActivity, ContatoAcvtivity::class.java))
                }
                R.id.wsPage -> {
                    startActivity(Intent(this@WorldskillsActivity, WorldskillsActivity::class.java))
                }
                R.id.logoutPage -> {
                    startActivity(Intent(this@WorldskillsActivity, CadastroActivity::class.java))
                }
                R.id.loginPage -> {
                    startActivity(Intent(this@WorldskillsActivity, LoginActivity::class.java))
                }
            }

            true
        }

        val listaSpinner = arrayOf("Desenvolvimento de apps", "Refrigeração", "Computação em nuvem", "Automotiva", "Desenho em CAD")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, listaSpinner)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedItem = parent?.getItemAtPosition(position).toString()
                updateSpinner(selectedItem)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }


    }

    // onBack do menu

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        }else{
            super.onBackPressed()
        }
    }

    // SPINNER

    private fun updateSpinner(selectedItem: String) {

        when (selectedItem) {

            "Desenvolvimento de apps" -> {
                textView.text = "O desenvolvimento de aplicativos é o processo de criação de software para dispositivos móveis, como smartphones e tablets. Esse processo envolve a concepção, design, programação e testes de aplicativos para sistemas operacionais como Android e iOS. O objetivo é criar aplicações que ofereçam funcionalidades úteis, entretenimento ou serviços aos usuários. Desenvolver um app envolve a combinação de diversas tecnologias e habilidades, incluindo design de interface, lógica de programação e conhecimento das plataformas de distribuição, como Google Play e App Store. Com o crescimento da tecnologia móvel, o desenvolvimento de apps tornou-se uma área essencial e em constante evolução."
                imageView.setImageResource(R.drawable.img_6)
            }

            "Refrigeração" -> {
                textView.text = "A refrigeração é o processo de remoção de calor de um ambiente ou substância, reduzindo sua temperatura e mantendo-a abaixo da temperatura ambiente. Esse processo é fundamental para preservar alimentos, medicamentos e outros produtos perecíveis, retardando o crescimento de bactérias e fungos. A refrigeração é usada em uma variedade de aplicações, desde refrigeradores e freezers domésticos até sistemas de ar condicionado e refrigeração industrial. Os sistemas de refrigeração geralmente utilizam ciclos de compressão de vapor, onde um fluido refrigerante é evaporado e condensado para absorver e dissipar calor. Além de sua importância para a conservação de alimentos, a refrigeração também é crucial para o conforto térmico em ambientes fechados e para processos industriais que exigem controle de temperatura."
                imageView.setImageResource(R.drawable.img_7)
            }

            "Automotiva" -> {
                textView.text = "A indústria automotiva é o setor econômico responsável pela fabricação, desenvolvimento e comercialização de veículos motorizados, incluindo carros, caminhões, motocicletas e ônibus. Esse setor abrange uma ampla gama de atividades, desde o design e engenharia de veículos até a produção de componentes e montagem final. A indústria automotiva é uma das mais complexas e tecnologicamente avançadas, incorporando inovações em áreas como eletrônica, segurança, eficiência energética e sustentabilidade.\n" +
                        "\n" +
                        "Nos últimos anos, a indústria tem se transformado com o avanço de tecnologias como veículos elétricos, sistemas de assistência ao motorista (ADAS) e conectividade inteligente. A crescente demanda por veículos mais seguros, eficientes e ambientalmente amigáveis tem impulsionado a pesquisa e o desenvolvimento de novas tecnologias, como motores elétricos, baterias de alta capacidade e sistemas de condução autônoma. Além de sua importância econômica, a indústria automotiva desempenha um papel fundamental na mobilidade global, influenciando a forma como as pessoas e mercadorias se movem pelo mundo."
                imageView.setImageResource(R.drawable.img_10)
            }

            "Computação em nuvem" -> {
                textView.text = "Computação em nuvem é um modelo de entrega de serviços de computação, como armazenamento, processamento e rede, através da internet. Em vez de adquirir e manter infraestrutura física, as organizações e indivíduos podem acessar recursos de computação sob demanda, pagando apenas pelo que utilizam. A computação em nuvem oferece flexibilidade, escalabilidade e economia de custos, permitindo que as empresas ajustem rapidamente sua capacidade de acordo com suas necessidades.\n" +
                        "\n" +
                        "Existem diferentes tipos de serviços em nuvem, incluindo Infraestrutura como Serviço (IaaS), Plataforma como Serviço (PaaS) e Software como Serviço (SaaS). IaaS oferece recursos básicos como servidores virtuais e armazenamento, PaaS fornece uma plataforma para desenvolvimento e implantação de aplicativos, e SaaS oferece software pronto para uso, acessível pela web. A computação em nuvem é amplamente adotada por sua conveniência e eficiência, possibilitando inovações rápidas e facilitando a colaboração remota e o acesso global."
                imageView.setImageResource(R.drawable.img_9)
            }

            "Desenho em CAD" -> {
                textView.text = "Desenho em CAD (Desenho Assistido por Computador) refere-se ao uso de software para criar representações precisas de objetos ou projetos, seja em duas ou três dimensões. Essa tecnologia é amplamente utilizada em áreas como engenharia, arquitetura, design de produtos e manufatura. O software CAD permite que os designers criem, modifiquem, analisem e otimizem seus projetos com alta precisão. Ele facilita a visualização de como um produto ou estrutura final será, permitindo ajustes e melhorias antes da produção. Além disso, o CAD pode gerar documentos técnicos detalhados, como plantas e especificações, que são essenciais para a fabricação e construção. A utilização de CAD é um avanço significativo em comparação aos métodos tradicionais de desenho, oferecendo maior eficiência, precisão e versatilidade no desenvolvimento de projetos."
                imageView.setImageResource(R.drawable.img_8)
            }

            else -> {

            }

        }

    }
}