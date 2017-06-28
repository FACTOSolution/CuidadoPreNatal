package com.example.fmendes.cuidadoprenatalapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.fmendes.cuidadoprenatalapp.controller.adapter.ListviewAdapter;
import com.example.fmendes.cuidadoprenatalapp.controller.core.Noticia;

import java.util.ArrayList;

/**
 * Created by Fmendes on 01/06/2017.
 */

public class ListNoticias extends AppCompatActivity {

    public final static String POSITION_NOTICIA = "com.example.fmendes.cuidadoprenatal.POSITION_NOTICIA";

    public DrawerLayout drawerLayout;

    private ListView listView;
    private ListviewAdapter adapter;
    public static ArrayList<Noticia> arrayNoticia;
    public Toolbar toolbar;
    public int indice_categoria;

    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getNoticia();

        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);

        setUpToolbat();

        setUpNavDrawer();

    }

    public void getNoticia(){

        arrayNoticia = new ArrayList<Noticia>();

        listView = (ListView)findViewById(R.id.listview_itens);

        adapter = new ListviewAdapter(getApplicationContext());


        Intent intent = getIntent();
        int posit = intent.getIntExtra(MainActivity.POSITION_CATEGORY, 0);

        indice_categoria = posit;

        if(posit == R.id.categoria_1) {
            noticia1_1();
            noticia1_2();
        }

         else if( posit == R.id.categoria_2) {

            noticia2_1();
            noticia2_2();
            noticia2_3();
            noticia2_4();
            noticia2_5();
        }
        else if(posit == R.id.categoria_3){

            noticia3_1();
            noticia3_2();
            noticia3_3();

        }
        else if(posit == R.id.categoria_4){

            noticia4_1();
            noticia4_2();
            noticia4_3();
            noticia4_4();
            noticia4_5();
        }


        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent detailNoticia = new Intent(getApplicationContext(), DetailNoticia.class);
                detailNoticia.putExtra(POSITION_NOTICIA, position);
                startActivity(detailNoticia);
            }
        });

    }

    public void noticia1_1(){

        Noticia noticia = new Noticia();
        noticia.setTitulo("Sinais de Alerta na Gravidez");
        noticia.setImagemAutor(R.drawable.user);
        noticia.setImg(R.drawable.sinais_alerta);
        noticia.setAutor("Autor");
        noticia.setDescricao("Sinais de Alerta na Gravidez – Procure o serviço de saúde se apresentar:\n\n" +
                "Fortes dores de cabeça, contrações regulares (endurecimento da barriga), apresentar muito inchaço, perda total ou parcial da visão, febre, perda de líquido, diminuição dos movimentos do feto, sangramento vaginal, Dificuldade para respirar.\n");

        arrayNoticia.add(noticia);
        adapter.addItem(noticia);


    }

    public void noticia1_2(){

        Noticia noticia = new Noticia();
        noticia.setTitulo("O que fazer nas principais queixas da gestação?");
        noticia.setImagemAutor(R.drawable.user);
        noticia.setImg(R.drawable.o_q_fazer);
        noticia.setAutor("Autor 2");
        noticia.setDescricao("1-Enjôo e vômitos \n" +
                "\n" +
                "•\tTer uma alimentação de 3/3 horas (3 refeições e 3 lanches por dia), evitando passar muito tempo sem comer;\n" +
                "•\tComer logo ao acordar, de preferência alimentos pastosos a secos (pão, bolacha, torrada);\n" +
                "•\tEvitar alimentos gordurosos, condimentados e com odor forte;\n" +
                "•\tManter boa ingestão de líquidos.\n" +
                "\n" +
                "Para diminuir as náuseas pode ser utilizado gengibre, camomila, vitamina B6 e /ou acunpuntura de acordo com as opções disponíveis e preferências da mulher. \n" +
                "\nSe ocorrer a manutenção dos sintomas procurar um profissional de saúde para avaliação.\n" +
                "\n" +
                "2-Azia, queimação e dor no estômago\n" +
                "\n" +
                "•\tSeguir a alimentação semelhante à indicada para enjôo e vômitos;\n" +
                "•\tEvitar beber líquidos durante as refeições;\n" +
                "•\tEvitar ficar na posição deitada após as refeições;\n" +
                "•\tIngerir líquidos gelados na crise de azia;\n" +
                "•\tSuspender o uso café, chá preto e mate, alimentos gordurosos, alimentos picantes, frutas cítricas (laranja, caju, acerola, abacaxi, limão) álcool e fumo. \n" +
                "\n" +
                "Se ocorrer a manutenção dos sintomas procurar um profissional de saúde para avaliação e prescrição de medicamentos.\n" +
                "\n" +
                "3-Salivação excessiva \n" +
                "\n" +
                "•\tSeguir a alimentação semelhante à indicada para enjôo e vômitos;\n" +
                "•\tAumentar a ingestão de líquidos.\n" +
                "\n" +
                "4-Fraquezas e Desmaios\n" +
                " \n" +
                "•\tNão fazer mudanças bruscas de posição;\n" +
                "•\tDieta de 3/3 horas, evitando grandes intervalos entre as refeições;\n" +
                "•\tEvitar também ingerir grandes quantidades de alimentos de uma só vez;\n" +
                "•\tPara melhorar sente-se com a cabeça abaixada ou deite de lado, respirando profunda e pausadamente.\n" +
                " \n" +
                "5-Gases e intestino preso\n" +
                "\n" +
                "•\tDieta rica em fibras: frutas cítricas (laranja, abacaxi, goiaba, acerola), verduras, mamão, ameixas e cereais integrais (aveia, linhaça, trigo e arroz integral, milho, quinoa); \n" +
                "•\tAumentar a ingestão de líquidos;\n" +
                "•\tFazer caminhada regularmente.\n" +
                "\n" +
                "6-Hemorróidas \n" +
                "\n" +
                "•\tAlimentação rica em fibras: frutas cítricas (laranja, abacaxi, goiaba, acerola), verduras, mamão, ameixas e cereais integrais (aveia, linhaça, trigo e arroz integral, milho, quinoa); \n" +
                "•\tEvitar usar papel higiênico, fazer a higiene íntima com água e sabão, enxugando com uma toalha macia após evacuação (defecar).\n" +
                "\nAgende consulta, se houver dor ou sangramento anal com frequência.\n" +
                "\n7-Corrimento vaginal \n" +
                "\n" +
                "•\tO aumento de fluxo vaginal é comum na gestação por isso só use creme vaginal prescrito pelo profissional de saúde;\n" +
                "\nAgende sua consulta pré-natal se houver secreção de cor amarelada, esverdeada, com mau cheiro ou caso haja coceira. \n" +
                "\n" +
                "8-Problemas Urinários \n" +
                "\nA vontade de urinar várias vezes é comum no início e no final da gestação (devido ao aumento do útero comprimindo à bexiga);\n" +
                "\n•\tAumentar a ingestão de líquidos.\n" +
                "\nInforme na consulta pré-natal se sente dor ao urinar, desconforto na região do baixo ventre e sangramento na urina.\n" +
                "\n9-Falta de ar e dificuldade pra respirar\n" +
                " \n" +
                "•\tProcure ficar de repouso deitada do lado esquerdo;\n" +
                "•\tPara diminuir a ansiedade converse com alguém sobre suas angústias.\n" +
                "Se houver outros sintomas como tosse, febre, inchaço, chiado no peito ou outros procure avaliação. \n" +
                "\n10-Dor nas costas\n" +
                "\n" +
                "•\tProcure manter a coluna reta ao sentar e ao andar;\n" +
                "•\tUsar apenas calçados baixos e confortáveis;\n" +
                "•\tRealizar atividades de alongamento e orientação postural. \n" +
                "•\tExercícios regulares evitam dores lombares e pélvicas. \n" +
                "\n" +
                "11-Sangramento nas gengivas\n" +
                " \n" +
                "•\tEscove os dentes após as refeições e antes de dormir;\n" +
                "•\tUtilize fio dental.\n" +
                "\n" +
                "Procure atendimento odontológico.\n" +
                "\n" +
                "12-Varizes\n" +
                "\n" +
                "•\tEvite ficar muito tempo em pé ou sentada;\n" +
                "•\tDescanse com as pernas elevadas (20 minutos) várias vezes ao dia;\n" +
                "•\tEvite roupas apertadas;\n" +
                "•\tUse meia-calça elástica de descanso para gestante, se possível. \n" +
                "\n" +
                "13-Câimbras\n" +
                " \n" +
                "•\tDurante a crise massagear o músculo contraído e aplicar compressa morna no local;\n" +
                "•\tNão exagerar no exercício físico.\n" +
                "\n" +
                "14-Manchas escuras no rosto \n" +
                "\n" +
                "•\tUsar protetor solar;\n" +
                "•\tEvitar se expor ao sol diretamente, utilizar chapéu,bonés,viseiras sombria ou guarda-sol e óculos.\n" +
                "\n" +
                "15-Nariz entupido e sangramento nasal \n" +
                "\n" +
                "•\tUse soro fisiológico em cada nariz se houver congestão;\n" +
                "•\tApertar levemente o nariz em caso de sangramento.\n" +
                "\n" +
                "16-Edema (inchaço)\n" +
                "\n" +
                "•\tPara aliviar o edema a gestante deve evitar permanecer em pé ou sentada por muito tempo. \n" +
                "•\tA posição mais indicada para deitar é do lado esquerdo que favorece a circulação do sangue.\n");

        arrayNoticia.add(noticia);
        adapter.addItem(noticia);



    }

    public void noticia2_1(){

        Noticia noticia = new Noticia();
        noticia.setTitulo("Cuidado Pré-Natal");
        noticia.setImagemAutor(R.drawable.user);
        noticia.setImg(R.drawable.cuidado_pre_natal);
        noticia.setAutor("Autor");
        noticia.setDescricao("Você sabia?\n\n" +
                "\tA Organização Mundial de Saúde (OMS) recomenda no mínimo 8 (oito) consultas de pré-natal para reduzir a mortalidade perinatal e melhorar a experiência das mulheres com os cuidados.\n" +
                "\nO pré-natal de mulheres com filho que nasce antes do tempo foi sempre de qualidade inferior quando comparado com mulheres de filho que nasce no tempo correto. \n" +
                "\nEstudos mostram que as mulheres que vivenciam ou tinham vivenciado violência física pelo parceiro iniciaram o pré-natal atrasado e realizaram número menor de consultas do que o preconizado pelo Ministério da Saúde.\n" +
                "\nPesquisas revelam que mais da metade das mães não recebem aconselhamento sobre risco de violência por parceiro íntimo na gravidez. \n" +
                "\nEstudos mostram que as adolescentes tem duas vezes mais chances de iniciar o pré-natal tarde em comparação com mulheres mais velhas. \n" +
                "\nPara cuidar da saúde do seu bebê cumpra o calendário de consultas regularmente e sigas a orientações do profissional de saúde.\n");

        arrayNoticia.add(noticia);
        adapter.addItem(noticia);


    }

    public void noticia2_2(){

        Noticia noticia = new Noticia();
        noticia.setTitulo("Conheça os Exames Recomendados durante o Pré-natal");
        noticia.setImagemAutor(R.drawable.user);
        noticia.setImg(R.drawable.exames_recomendados);
        noticia.setAutor("Autor");
        noticia.setDescricao("Na 1ª consulta devem ser solicitados os seguintes exames: \n\n" +
                "1-\tHemograma; \n" +
                "2-\tTipo sanguíneo e fator Rh;\n" +
                "3-\tEletroforese de hemoglobina;\n" +
                "4-\tGlicemia de jejum;\n" +
                "5-\tUrina tipo I;\n" +
                "6-\tUrocultura e antibiograma;\n" +
                "7-\tTeste rápido par sífilis ou VDRL;\n" +
                "8-\tTeste rápido para HIV ou sorologia; \n" +
                "9-\tSorologia para hepatite B (HbsAg);\n" +
                "10-\tToxoplasmose;\n" +
                "11-\t Ultrassonografia obstétrica. \n" +
                "\nNo 2º trimestre\n\n" +
                "1-\tCoombs indireto para gestantes com sangue negativo;\n" +
                "2-\tTeste de tolerância à glicose para gestantes com fator de risco ou glicemia de 90 a 110mg/dl em exame anterior.\n" +
                "\nNo 3º trimestre\n\n" +
                "1-\tHemograma;\n" +
                "2-\tGlicemia em jejum;\n" +
                "3-\tUrina tipo I;\n" +
                "4-\tUrocultura e antibiograma;\n" +
                "5-\tTeste rápido para sífilis ou VDRL;\n" +
                "6-\tTeste rápido para HIV ou sorologia;\n" +
                "7-\tSorologia para hepatite B;\n" +
                "8-\tToxoplasmose (se não reagente no primeiro exame).\n" +
                "\nOutros exames que podem ser solicitados: \n\n" +
                "1-\tParasitológico de fezes;\n" +
                "2-\tTeste de Malária (em áreas de risco); \n" +
                "3-\tCitologia oncótica (prevenção do câncer de colo do útero).\n" +
                "\n" +
                "\nPrevenção do Câncer de Colo de Útero\n\n" +
                " O profissional de saúde que realiza seu pré-natal solicitará o exame de prevenção do câncer de colo uterino de acordo com as recomendações atuais.\n" +
                "\nO Câncer de Colo Uterino (CCU) é o terceiro tipo de câncer mais frequente entre mulheres, atrás dos cânceres de mama e colorretal.\n");

        arrayNoticia.add(noticia);
        adapter.addItem(noticia);


    }

    public void noticia2_3(){

        Noticia noticia = new Noticia();
        noticia.setTitulo("Orientações Nutricionais");
        noticia.setImagemAutor(R.drawable.user);
        noticia.setImg(R.drawable.orientacoes_nutricionais);
        noticia.setAutor("Autor");
        noticia.setDescricao("Vitaminas\n" +
                "\nRecomenda-se suplementação de ferro e ácido fólico para prevenção de doenças na mãe e no bebê.\n" +
                "\n•\tFerro (30 a 60mg de ferro /dia) \n" +
                "\nDurante toda gestação até 3 (três) meses após o parto.\n" +
                "\n•\tÁcido fólico (0,4 mg /dia) \n" +
                "\nAntes de engravidar até o final da gestação. \n" +
                "\nAs vitaminas devem ser tomadas de preferência 1h antes da refeição de com suco de frutas cítricas (acerola, laranja, goiaba, limão). As frutas ajudam na absorção do ferro. \n" +
                "\nLembre-se: em caso de azia, evitar as frutas cítricas. \n" +
                "\nEvitar consumir na mesma refeição alimentos que atrapalham a absorção do ferro como café, leite e chá. \n" +
                "\nBenefícios: \n\n" +
                "A ingestão de sulfato ferroso reduz a anemia da mãe e baixo peso da criança ao nascer.\n" +
                "\nO uso do ácido fólico protege contra defeitos do tubo neural (sistema nervoso do feto). \n" +
                "\nPara evitar a anemia, a gestante deve consumir diariamente alimentos ricos em ferro, como carnes, vísceras, feijão, soja, folhas verde-escuras, grãos integrais, castanhas, entre outros. \n" +
                "\nO ácido fólico é encontrado em alimentos como vegetais folhosos verdes frutas cítricas, alimentos integrais, legumes e bife de fígado.\n" +
                "\nVocê sabia?\n" +

                "\nEm mulheres que já tenham um filho com defeito no sistema nervoso para reduzir o risco de repetição deste defeito é recomendado 4,0-5,0 mg de ácido fólico por dia na próxima gravidez.\n" +
                "\nA alimentação deve ser saudável e balanceada, estimulando a ingestão de água e fibras. A gestante deve ingerir frutas, verduras e legumes, leite e derivados, que contêm nutrientes importantes para o crescimento do bebê, da mesma forma que podem contribuir para evitar o ganho excessivo de peso. \n" +
                "\nO consumo de alimentos regionais é saudável durante a gestação. Eles podem ser encontrados em feiras, mercados e no quintal de casa.\n" +
                "\nAbaixo segue a lista de algumas vitaminas e minerais que devem ser consumidas no período da gestação: \n" +
                "\n•\tCálcio \n" +
                "\n" +
                "Pode ser encontrado em leite e derivados. \n" +
                "\n" +
                "•\tVitamina A\n\n" +
                "Pode ser encontrado em leite, fígado, vegetais folhosos verdes, frutas amarelo-alaranjadas (mamão, manga, caju), vegetais amarelos (abóbora e cenoura).\n" +
                "\n•\tVitamina D\n" +
                "\n" +
                "Está presente no atum, sardinha, gema de ovos, óleo de peixe, fígado e salmão.\n" +
                "Recomenda-se banho de sol no início da manhã e no final da tarde.\n" +
                "\n•\tVitamina C \n" +
                "\n" +
                "É encontrado em frutas cítricas (goiaba, tangerina, acerola, limão), no tomate e no brócolis.\n" +
                "\n" +
                "\nOutras orientações \n\n" +
                "•\tAs frutas, legumes e verduras devem ser lavadas e colocadas de molho por 10 (dez) minutos em água + hipoclorito de sódio a 1% (1 colher de sopa de hipoclorito para 1 litro de água). Depois realizar enxague do alimento em água. Esse cuidado evita muitas doenças que podem ser prejudiciais à saúde da gestante e do bebê;\n" +
                "•\tComer mais peixe e frango e escolher carnes magras;\n" +
                "•\tEvitar o consumo de carnes cruas e mal passadas;\n" +
                "•\tUsar no preparo dos alimentos pequena quantidade de óleos vegetais (de soja, canola, girassol, milho ou algodão). \n" +
                "•\tDiminuir o consumo de sal de cozinha e de alimentos industrializados já que aumentam o risco de pressão alta, doenças no coração e rins.\n" +
                "•\tDar preferência às frutas como sobremesa em lugar dos doces. As sobremesas doces aumentam o risco de complicações na gestação, excesso de peso, obesidade, diabetes gestacional e pressão alta.\n" +
                "\nVocê sabia?\n\n" +

                "\nA Organização Mundial de Saúde- OMS recomenda para mulheres com ingestão excessiva de cafeína (mais de 300 mg por dia)  reduzam a quantidade diária durante a gravidez para evitar aborto espontâneo e bebês com baixo peso. \n" +
                "\nA cafeína pode ser encontrada em café, chás, refrigerantes e chocolates.\n" +

                "\n" +
                "Ganho de Peso na Gestação\n\n" +
                "Os hábitos alimentares saudáveis e adequados exercem uma importante influência sobre o resultado da gravidez.\n" +
                "\nProcure conversar com o profissional que realiza seu pré-natal sobre o ganho de peso recomendado na gestação e estabeleça as estratégias para melhoria dos hábitos alimentares.\n" +
                "\nPara mulher de baixo peso antes da gestação o ganho recomendado é de 12,5 Kg a 18 Kg; mulheres com peso normal o ganho recomendado é de 11,5Kg a 16Kg; mulheres com sobrepeso recomenda-se aumentar de 7Kg a 11,5Kg e em mulheres obesas menos de 7Kg ." +
                "\n" +
                "\nO ganho de peso inadequado interfere no crescimento e desenvolvimento do recém-nascido.  \n" +
                "\nA gestante acima do peso tem maior risco para diabetes na gestação, aumento da pressão arterial, nascimento antes do tempo, defeitos no sistema nervoso da criança e ao aumento de partos cesáreo. \n" +
                "\nA gestante com baixo peso há um maior risco de parto antes do tempo. \n" +
                "\nVocê sabia?\n\n" +

                "\nGrávidas com baixo peso antes da gestação tem 9 (nove) vezes mais chance de ganho insuficiente de peso, quando comparadas com mulheres de peso normal antes da gestação.\n" +
                "\nMulheres que ganham peso abaixo das diretrizes tem mais chances de terem recém-nascidos pequenos para a idade gestacional. \n" +
                "\nMulheres com peso normal e mulheres com baixo peso que seguem as recomendações têm um risco menor de baixo peso ao nascer. \n" +
                "\nAs mulheres que deram à luz fetos com baixo peso ao nascer tinham um risco cinco vezes maior de asfixia neonatal no prazo de 7 (sete) dias após o nascimento. \n" +
                "\nA gestante que inicia o pré-natal com sobrepeso/obesidade tem mais chance de ter ganho de peso excessivo na gravidez. \n" +

                "\nDez Passos para Alimentação Saudável em Gestantes \n\n" +
                "   Fonte Ministério da Saúde/MS \n" +
                "\n1.\tFaça pelo menos três refeições (café da manhã, almoço e jantar) e dois lanches saudáveis por dia, evitando ¬ ficar mais de três horas sem comer. Entre as refeições beba água, pelo menos 2 litros (6 a 8 copos) por dia.\n" +
                "\n2.\tInclua diariamente nas refeições seis porções do grupo de cereais (arroz, milho, pães e alimentos feitos com farinha de trigo e milho), tubérculos como as batatas e raízes como a mandioca/ macaxeira/aipim. Dê preferência aos alimentos na sua forma mais natural, pois além de serem fontes de carboidratos, são boas fontes de ¬ fibras, vitaminas e minerais.\n" +
                "\n3.\tProcure consumir diariamente pelo menos três porções de legumes e verduras como parte das refeições e três porções ou mais de frutas nas sobremesas e lanches.\n" +
                "\n4.\tComa feijão com arroz todos os dias ou, pelo menos, cinco vezes por semana. Esse prato brasileiro é uma combinação completa de proteínas e excelente para a saúde.\n" +
                "\n5.\tConsuma diariamente três porções de leite e derivados e uma porção de carnes, aves, peixes ou ovos. Retire a gordura aparente das carnes e a pele das aves antes da preparação, tornando esses alimentos mais saudáveis!\n" +
                "\n6.\tDiminua o consumo de gorduras. Consuma, no máximo, uma porção diária de óleos vegetais, azeite e manteiga. Fique atenta aos rótulos (embalagens) dos alimentos e pre¬fira aqueles livres de gorduras trans.\n" +
                "\n7.\tEvite refrigerantes e sucos industrializados, biscoitos recheados e outras guloseimas no seu dia a dia.\n" +
                "\n8.\tDiminua a quantidade de sal na comida e retire o saleiro da mesa. Evite consumir alimentos industrializados com muito sal (sódio) como hambúrguer, charque, salsicha, linguiça, presunto, salgadinhos, conservas de vegetais, sopas prontas, molhos e temperos prontos.\n" +
                "\n9.\tPara evitar a anemia, consuma diariamente alimentos fontes de ferro como: carnes, vísceras, feijão, lentilha, grão-de-bico, soja, folhas verde-escuras, grãos integrais, castanhas e outros. Consuma junto alimentos fontes de vitamina C como: acerola, laranja, caju, limão e outros. \n" +
                "\n10.\tMantenha o seu ganho de peso gestacional dentro de limites saudáveis. Pratique, seguindo orientação de um profissional de saúde, alguma atividade física e evite as bebidas alcoólicas e o fumo.\n");

        arrayNoticia.add(noticia);
        adapter.addItem(noticia);


    }

    public void noticia2_4(){

        Noticia noticia = new Noticia();
        noticia.setTitulo("Verificando a Pressão Arterial");
        noticia.setImagemAutor(R.drawable.user);
        noticia.setImg(R.drawable.verificando_pressao_arterial);
        noticia.setAutor("Autor");
        noticia.setDescricao("A medida da pressão arterial deve ser realizada em todas as consultas de pré-natal.\n" +
                "\nA pressão alta ou hipertensão acontece quando a pressão arterial maior atinge valor maior ou igual a 140 mmHg e/ou a pressão menor atinge o valor maior ou igual a 90 mmHg.\n" +
                "\nO aumento da pressão na gestação leva a doenças como pré-eclâmpsia e eclâmpsia que estão associadas a complicações graves fetais e maternas. \n" +
                "\nO tratamento da hipertensão na gravidez é feito com medicamentos e mudanças de hábitos alimentares.\n" +
                "\nPara verificar a pressão tome os seguintes cuidados: \n" +
                "•\tNão esteja de bexiga cheia;\n" +
                "•\tEvite exercícios físicos pelo menos 60 (sessenta) minutos antes;\n" +
                "•\tA gestante deve estar na posição sentada.\n" +
                "\n" +
                "Não é recomendado ingerir bebidas alcoólicas, fumar e /ou tomar café.\n");

        arrayNoticia.add(noticia);
        adapter.addItem(noticia);


    }

    public void noticia2_5(){

        Noticia noticia = new Noticia();
        noticia.setTitulo("Vacinas Indicadas");
        noticia.setImagemAutor(R.drawable.user);
        noticia.setImg(R.drawable.vacinas);
        noticia.setAutor("Autor");
        noticia.setDescricao("As vacinas aplicadas no pré-natal dão proteção a gestante e ao recém-nascido. De acordo com seu estado vacinal anterior é feito o planejamento das vacinas que devem ser administradas na gestação.\n" +
                "\n• dT/dTpa  \n\n" +
                "A vacina dT protege contra difteria e tétano.\n" +
                "\nA vacina dTpa protege contra difteria, tétano e coqueluche (aplicada a partir da 20ª semana de gestação).\n" +
                "\n• Hepatite B \n\n" +
                "Protege contra o vírus da hepatite B.\n" +
                "\n• Influenza \n\n" +
                "Protege contra o vírus da gripe.\n");

        arrayNoticia.add(noticia);
        adapter.addItem(noticia);


    }

    public void noticia3_1(){

        Noticia noticia = new Noticia();
        noticia.setTitulo("Infecção pelo Zika Vírus na Gravidez");
        noticia.setImagemAutor(R.drawable.user);
        noticia.setImg(R.drawable.zica_virus);
        noticia.setAutor("Autor");
        noticia.setDescricao("A infecção vírus tipo Zika é transmitida principalmente para os seres humanos pela picada do mosquito Aedes e através do sexo. \n" +
                "\nOs sintomas da doença:\n\n" +
                "•\tVermelhidão leve em tórax, membros e face, por vezes, coceira, que pode ocorrer em qualquer parte do corpo; \n" +
                "•\tDor nas articulações e no corpo;\n" +
                "•\tMal-estar;\n" +
                "•\tInchaço no membro inferior; \n" +
                "•\tDor de cabeça;\n" +
                "•\tOlhos vermelhos;\n" +
                "•\tDor de garganta e tosse seca;\n" +
                "•\tVômitos.\n" +
                "\nDe todos os sintomas o mais comum é a vermelhidão no corpo." +
                "\nComplicações da doença na gravidez:\n\n" +
                "\nEfeitos sobre o sistema nervoso, tanto a mãe como no bebê (microcefalia).\n" +
                "\nPrevenção Zika na gravidez:\n" +
                "\n•\tEliminar criadouros (locais que acumulam água parada, exemplos: pneus, latas, vidros, garrafas, tampinhas de garrafas, vasos de flores, pratos de vasos, caixas de água e outros) do mosquito em casa e arredores; \n" +
                "\n•\tAs mulheres grávidas precisam usar repelente, roupa de manga comprida e calças; \n" +
                "\n•\tColocar telas em janelas e portas.\n" +
                "\nA mulher com sintomas de Zica vírus deve manter os cuidados com a picada do mosquito para evitar a disseminação da infecção e procurar consulta pré-natal. \n" +
                "\nManter relações sexuais com preservativo previne a transmissão da doença.\n");

        arrayNoticia.add(noticia);
        adapter.addItem(noticia);


    }

    public void noticia3_2(){

        Noticia noticia = new Noticia();
        noticia.setTitulo("Uso de Álcool e outras Substâncias");
        noticia.setImagemAutor(R.drawable.user);
        noticia.setImg(R.drawable.uso_de_alcool);
        noticia.setAutor("Autor");
        noticia.setDescricao("Consumir drogas ou álcool durante a gravidez não é aconselhável. No planejamento da gestação, a mulher deve abandonar esses hábitos e vícios que causam efeitos negativos para a mãe e o feto. \n" +
                "\nA gravidez é um momento em que muitas mulheres são motivadas a parar, as mulheres que por ventura não conseguirem parar de beber por conta própria devem procurar apoio e assistência. \n" +
                "\nO álcool pode levar síndromes e deficiência mental no feto. \n" +
                "\nO consumo do álcool pode estar associado ao aumento do risco de aborto. \n" +
                "\nO álcool é transferido facilmente para o leite humano durante a amamentação.\n");

        arrayNoticia.add(noticia);
        adapter.addItem(noticia);


    }

    public void noticia3_3(){

        Noticia noticia = new Noticia();
        noticia.setTitulo("Fumo e Exposição à Fumaça do Cigarro");
        noticia.setImagemAutor(R.drawable.user);
        noticia.setImg(R.drawable.proibido);
        noticia.setAutor("Autor");
        noticia.setDescricao("\nDurante a gestação deve ser interrompido o uso do cigarro. O ideal é que a mulher tente parar de fumar antes de engravidar. \n" +
                "\nO fumo aumenta o número de atraso no crescimento fetal, trabalho de parto prematuro (antes do tempo), descolamento de placenta, aumento das doenças na infância, aumento de problemas escolares e diminuição do coeficiente de inteligência – QI.\n" +
                "\nÉ recomendado que as mulheres evitem exposição à fumaça do cigarro.\n" +
                "\nVocê sabia?\n" +
                "\nEstudos mostram que a maior parcela das mulheres grávidas que fumam começa o pré-natal tardiamente, após as 20 semanas. \n" +
                "\nAs mães não devem utilizar cigarro após o parto pois a nicotina (substância presente no cigarro) e seus compostos são passados ao bebê através do leite. Para reduzir a exposição da criança à fumaça, não é recomendado fumar próximo à ela.\n" +
                "\nAs mulheres que pararam de fumar requerem maior atenção, a fim de alcançar um ganho de peso saudável. \n");

        arrayNoticia.add(noticia);
        adapter.addItem(noticia);


    }

    public void noticia4_1(){

        Noticia noticia = new Noticia();
        noticia.setTitulo("Sexo na Gestação");
        noticia.setImagemAutor(R.drawable.user);
        noticia.setImg(R.drawable.sexo_na_gestacao);
        noticia.setAutor("Autor");
        noticia.setDescricao("Na gestação podem ocorrer mudanças no desejo e na disposição sexual devido diversos fatores.\n" +
                "\nAs relações sexuais são permitidas. Evitar atividade sexual na presença de cólicas, sangramento ou perda de líquido. Tire suas dúvidas durante a consulta pré-natal.\n" +
                "\nO uso do preservativo masculino ou feminino é indicado para proteção contra Infecções Sexualmente Transmissíveis – Ists.\n");

        arrayNoticia.add(noticia);
        adapter.addItem(noticia);


    }

    public void noticia4_2(){

        Noticia noticia = new Noticia();
        noticia.setTitulo("Atividade Física na Gravidez");
        noticia.setImagemAutor(R.drawable.user);
        noticia.setImg(R.drawable.atividade_fisica);
        noticia.setAutor("Autor");
        noticia.setDescricao("A mulher que praticava alguma atividade antes da gravidez pode continuar, desde que adequando à gestação. Mulheres que não realizavam atividade física podem começar uma atividade, desde que com orientação e supervisão. \n" +
                "\nA yoga, hidroginástica, a caminhada são atividades bem recomendadas para as mulheres grávidas, pois melhoram a capacidade física e cardiovascular. \n" +
                "\nExistem algumas doenças na gravidez que impedem os exercícios físicos, converse com um profissional de saúde caso apresente algum problema.\n" +
                "\nVocê sabia?\n\n" +
                "A Organização Mundial de Saúde (OMS) recomenda a manutenção da atividade física na gravidez.  Na ausência de contraindicações é recomendado 30 minutos de exercício físico todos os dias da semana.\n" +
                "\nOs exercícios quando desenvolvidos de forma adequada contribuem para a manutenção e promoção de um estilo de vida saudável. \n" +
                "\nEstudos mostram que é preciso melhorar a divulgação das recomendações sobre atividade física, pois os níveis de atividade física durante a gravidez são baixos.\n" +
                "\nPesquisas revelam que mulheres que fazem pouca atividade física durante a gravidez tiveram um risco duas vezes maior de ganhar peso acima do recomendado.\n");

        arrayNoticia.add(noticia);
        adapter.addItem(noticia);


    }

    public void noticia4_3(){

        Noticia noticia = new Noticia();
        noticia.setTitulo("Preparo para o parto");
        noticia.setImagemAutor(R.drawable.user);
        noticia.setImg(R.drawable.parto);
        noticia.setAutor("Autor");
        noticia.setDescricao("Como eu sei que estou em trabalho de parto? \n" +
                "\n•\tPróximo à data do parto a barriga endurece com intervalos que não duram muito e pode sair da sua vagina uma secreção amarelada, com manchas de sangue. \n" +
                "•\tProcure um serviço de saúde se a barriga endurecer a cada 5 (cinco) minutos, por 30 (trinta) segundos ou mais, ou se perder líquido pela vagina.\n" +
                "\n" +
                "Qual o melhor tipo de parto?\n" +
                "\n" +
                "De uma forma geral, o parto normal ou vaginal é a maneira ideal de dar à luz. É natural, dando a mulher uma recuperação mais rápida. \n" +
                "\n" +
                "Durante o trabalho de parto procure uma posição que traga conforto e favoreça a saída do bebê.\n" +
                "\nAlém da posição deitada você pode ficar de cócoras, sentada na bola, de joelhos. Você também pode caminhar e movimentar-se, tomar banho de chuveiro ou banheira, beber água e comer alimentos leves e respirar profundamente.\n" +
                "\nO parto por cesariana tem sido associado ao aumento do risco de obesidade e diabetes do tipo 1 na criança.\n" +
                "\nO parto cesáreo traz mais riscos da criança desenvolver alergias e problemas respiratórios na idade adulta; Mais riscos da mãe ter febre, infecção, hemorragia e interferência na amamentação. \n" +
                "\nO melhor tipo de parto é aquele mais adequado às condições de sua gravidez, ou seja, que atendem ao seu filho e as possíveis alterações durante o pré-natal.\n" +
                "\nConverse com um profissional de saúde sobre isso. Faça seu plano de parto por escrito na caderneta da gestante e entregue à equipe na maternidade.\n" +
                "\nVocê sabia?\n" +
                "\nÉ recomendado que os médicos incentivem o parto vaginal planejado após a cesariana anterior depois de observados os riscos e benefícios para a paciente.Os planos para o parto vaginal devem ser reavaliados no hospital considerando fatores de admissão e alterações.\n" +
                "\nFique Atenta aos Sinais Violência à Mulher durante o Parto\n" +
                "\n•\tOcorrência de agressões verbais ou físicas;\n" +
                "•\tAdoção de práticas inadequadas como lavagem intestinal, retirada de pêlos íntimos, realização de corte na região vaginal sem indicação correta, não permitir que a mulher procure uma posição confortável durante o trabalho de parto e exame de toque por mais de um profissional;\n" +
                "•\tO serviço de saúde recusar a presença do acompanhante da mulher na sala de parto; \n" +
                "•\tTransferência para outro serviço de saúde sem garantia de vaga e sem transporte seguro. \n" +
                "\nSe você sofrer algum tipo de violência, ligue para 180 – Central de Atendimento à Mulher e procure ajuda. A ligação é gratuita. \n");

        arrayNoticia.add(noticia);
        adapter.addItem(noticia);


    }

    public void noticia4_4(){

        Noticia noticia = new Noticia();
        noticia.setTitulo("Promoção do Aleitamento Materno");
        noticia.setImagemAutor(R.drawable.user);
        noticia.setImg(R.drawable.amamentacao);
        noticia.setAutor("Autor");
        noticia.setDescricao("O preparo para amamentação deve ser iniciado ainda na gravidez para que a mulher possa amamentar de forma efetiva e tranquila. \n" +
                "\nProcure um profissional de saúde para ajudá-la nesse momento.\n" +
                "\nCUIDADOS COM AS MAMAS QUE AJUDAM A AMAMENTAÇÃO:\n\n" +
                "•\tUsar sutiã durante toda a gestação;\n" +
                "•\tDar banhos de sol na mama por 15 minutos (no início da manhã ou no final da tarde) ou banho de luz com lâmpadas de 40 watts, a cerca de um palmo de distância;\n" +
                "•\tNão é recomendado o uso de sabonetes, cremes ou pomadas nos mamilos (bico do peito);\n" +
                "•\tO banho diário é suficiente para a higiene do peito.\n" +
                "A amamentação consegue suprir todas as necessidades nos primeiros meses de vida, para o bebê crescer e se desenvolver sadio. Por isso devemos oferecer somente o leite do peito durante os primeiros seis meses, não sendo necessário oferecer água, chá e nenhum outro alimento. \n" +
                "O primeiro leite que sai após o parto pode ser claro ou amarelo, grosso ou ralo chama-se colostro. O colostro protege o bebê contra muitas doenças. A descida do leite ou “apojadura” ocorre normalmente 24h a 72 h após o parto. \n" +
                "\nBENEFÍCIOS DO LEITE MATERNO PARA O BEBÊ: \n\n" +
                "•\tContêm vitaminas, minerais, gorduras, açúcares, proteínas que não se pode encontrar em nenhum outro leite; \n" +
                "•\tÉ de fácil digestão, apropriado ao estômago da criança;\n" +
                "•\tSó ele tem substâncias que protegem o bebê contra doenças como: diarreia, pneumonias, infecção de ouvido, alergias, hipertensão arterial, diabetes, obesidade e muitas outras doenças; \n" +
                "•\tO leite materno não precisa ser comprado, está pronto a qualquer hora, sempre na temperatura certa e livre de impurezas;\n" +
                "•\tDar de mamar faz o bebê sentir-se seguro, é um ato de amor e carinho;\n" +
                "•\tA amamentação diminui o número de cáries, problemas na fala e ajuda na prevenção de defeitos no fechamento dos dentes;\n" +
                "•\tBebês que mamam apresentam melhor crescimento e desenvolvimento. \n" +
                "\nOUTROS BENEFÍCIOS:\n\n" +
                "•\tFortalece os laços afetivos entre mãe e filho;\n" +
                "•\tDiminui o sangramento da mãe no pós- parto, faz com que o útero volte ao tamanho normal e previne a anemia materna;\n" +
                "•\tContribui para evitar gravidez, caso a mulher esteja nos primeiros 6 (seis) meses do pós-parto, ainda não tenha menstruado e  amamentando exclusivamente (somente com  o leite materno);\n" +
                "•\tDiminui o risco de câncer de mama, ovários e doença cardiovascular na mãe. \n" +
                "\nPOR QUE DEVO EVITAR MAMADEIRA E CHUPETA? \n\n" +
                "•\tPor que podem atrapalhar o aleitamento materno;\n" +
                "•\tPode haver contaminação do leite durante o preparo e uso da mamadeira, ocasionando doenças no bebê;\n" +
                "•\tModificam a posição dos dentes, prejudicando fala e respiração;\n" +
                " \n" +
                "POSIÇÃO DE AMAMENTAR? \n" +
                "\n" +
                "•\tA mãe pode ficar deitada, sentada ou em pé. O importante é que esteja confortável;\n" +
                "•\tA barriga do bebê deve está voltada para o corpo da mãe;\n" +
                "•\tA cabeça e a coluna do bebê devem está em linha reta;\n" +
                "•\tA boca do bebê fica de frente o bico do peito;\n" +
                "•\tA criança deve ser apoiada pelo braço da mãe, que envolve a cabeça, o pescoço e a parte do seu tronco; \n" +
                "•\tO bebê deve colocar a maior parte da aréola (área mais escura e arredondada do peito) dentro da boca;\n" +
                "•\tO lábio inferior do bebê fica virado para fora; \n" +
                "•\tO queixo do bebê toca o peito da mãe;\n" +
                "•\tO nariz do bebê está livre.               \n" +
                "\n" +
                "QUANDO AMAMENTAR? \n\n" +
                "•\tOferecer o peito ainda na sala de parto, logo após o nascimento, independente do tipo de parto para estimular a produção e descida do leite;\n" +
                "•\tOferecer o peito em livre demanda, ou seja, sempre que o bebê quiser, sem restrições de horários e tempo da mamada. Quanto mais o bebê mamar, mais leite o peito irá produzir;\n" +
                "Sempre deixar o bebê esvaziar totalmente uma mama e só então oferecer a outra. Esse cuidado estimula a produção de leite e faz com que sejam aproveitadas todas as fases do leite. O leite do início da mamada tem mais água e anticorpos, o leite do final da mamada é mais rico em energia e sacia a fome do bebê.\n" +
                "\n" +
                "COMO TERMINAR A MAMADA? \n\n" +
                "•\tO bebê solta sozinho o peito, mas se for preciso interromper a mamada, a mãe coloca a ponta do dedinho no canto da boca do bebê para que ele solte o peito sem machucar.\n" +
                "\nPOSIÇÃO PARA O BEBÊ ARROTAR\n\n" +
                "•\tA mãe, o pai ou outro familiar deve levantar o bebê e apoiar a cabeça no seu ombro fazendo uma leve massagem nas costas.\n" +
                "\n" +
                "PASSOS PARA RETIRAR LEITE DO PEITO:\n\n" +
                "•\tEscolher um lugar limpo e tranquilo; \n" +
                "•\tPrender os cabelos;\n" +
                "•\tProteger a boca e o nariz com pano ou fralda; \n" +
                "•\tPreparar um frasco com tampa fervido por 15 minutos pode ser vidro de café, maionese, etc;\n" +
                "•\tMassagear o peito com a ponta de dois dedos iniciando na região da aréola (área mais escura da pele ao redor do bico do peito) indo até a mais distante do peito, apoiando o peito com a outra mão; Massagear as áreas mais doloridas por mais tempo;\n" +
                "•\tApoiar a ponta dos dedos (polegar e indicador) acima e abaixo da aréola, apertando o peito contra o tórax; com movimentos regulares, aproximando a ponta dos dedos, sem deslizar na pele;\n" +
                "•\tDesprezar os primeiros jatos e guardar o restante no recipiente.\n" +
                "\t\n" +
                "Como guardar o leite retirado para o próprio filho? \n" +
                "\n" +
                "•\tO leite pode ser coletado em vasilha limpa (fervida durante 15 minutos) e colocado em local fresco. Para evitar a diarréia, esse leite só deve ser usado até 6 (seis) horas após a coleta. \n" +
                "•\tO leite retirado do peito pode ser guardado em geladeira com segurança por até 12 horas e congelado por até 15 dias.\n" +
                "•\tPara alimentar o bebê com o leite aqueça em banho-maria. Oferecer com colher, copo ou xícara. O que sobrar não deve ser guardado novamente.\n" +
                "\n" +
                "PROBLEMAS QUE PODEM OCORRER COM A MAMA: \n" +
                "\n" +
                "Fissura ou rachadura \n\n" +
                "-Como evitar:\n\n" +
                "•\tManter os peitos enxutos; \n" +
                "•\tEvitar que os peitos fiquem muito cheios ou doloridos; \n" +
                "•\tPosicionar o bebê corretamente.\n" +
                "\n" +
                "Leite “empedrado” ou peito ingurgitado\n" +
                " \n" +
                "-Como evitar:\n" +
                "\n" +
                "•\tColocar o bebê para mamar sempre que ele quiser. Se as mamas estiverem muito cheias, retirar o excesso e oferecer o peito com maior frequência.\n" +
                "•\tCompressas frias de, no máximo, 20 minutos entre as mamadas;\n" +
                "•\tO melhor tratamento é a retirada do leite.\n" +
                "\n" +
                "Se não melhorar em 24 horas, a mama ficar vermelha e a mãe apresentar febre procure um serviço de saúde a fim de evitar complicações.\n" +
                "\nA AMAMENTAÇÃO DEVE SER EVITADA QUANDO: \n\n" +
                "•\tGestantes infectadas pelo vírus HIV, devido o risco de transmissão do vírus da mãe par o bebê;\n" +
                "•\tNenhum bebê deve mamar no peito de outra mãe. O motivo disso é que algumas doenças podem passar através do leite do peito.\n" +
                "\nUSO DE MEDICAMENTOS\n\n" +
                "Durante a amamentação só utilize medicamentos com orientação profissional. É mais seguro para o bebê e a produção do leite. \n" +
                "\nSempre informe ao seu médico que está amamentando.\n" +
                "\nDOAÇÃO LEITE HUMANO\n" +
                "\nQuando a mulher produz leite superior às necessidades do seu filho é possível doar o leite materno para outras crianças.\n" +
                "\nCaso deseje ser doadora, procure o banco de leite da maternidade mais próxima da sua casa e saiba como doar.\n" +
                "\nO leite doado passa por um tratamento antes de ser oferecido aos bebês.\n" +
                "\nVocê sabia?\n\n" +
                "O início tarde da amamentação acontece mais nas mães que não realizaram o pré-natal, mães submetidas à cesariana, mães sem resultado de exame para o HIV na hora do parto ou que declararam que a equipe do hospital não havia escutado suas dúvidas sobre amamentação. \n");

        arrayNoticia.add(noticia);
        adapter.addItem(noticia);


    }

    public void noticia4_5(){

        Noticia noticia = new Noticia();
        noticia.setTitulo("Conheça alguns dos seus Direitos");
        noticia.setImagemAutor(R.drawable.user);
        noticia.setImg(R.drawable.direitos);
        noticia.setAutor("Autor");
        noticia.setDescricao("•\tPrioridade nas filas;\n" +
                "\n•\tTer acompanhante de sua escolha na maternidade, inclusive durante o parto;\n" +
                "\n•\tConhecer e vincular-se à maternidade onde receberá assistência no âmbito do SUS;\n" +
                "\n•\tEstabilidade no emprego desde a constatação da gravidez até 5 (cinco) meses após o parto;\n" +
                "\n•\tDispensa do horário de trabalho sempre que comparecer às consultas e exames, mediante atestado;\n" +
                "\n•\tLicença- Maternidade correspondente a 120 (cento e vinte) dias, sem prejuízo do emprego, dos salários e dos demais benefícios e 180 (cento e oitenta) dias para servidor público. O funcionário da empresa privada que aderiu ao Programa Empresa Cidadã tem direito a mais 60 (sessenta) dias de afastamento; \n" +
                "\n•\tDois descansos especiais, de meia hora cada um, durante jornada de trabalho, para amamentação de seu filho, até que complete 6 (seis) meses;\n" +
                "\n•\tO pai tem direito a 20 (vinte) dias de afastamento do trabalho para acompanhar a mulher e o bebê, se for servidor público ou funcionário de empresa privada que aderiu ao Programa Empresa Cidadã. \n");

        arrayNoticia.add(noticia);
        adapter.addItem(noticia);


    }



    public void setUpToolbat(){

        toolbar = (Toolbar) findViewById(R.id.toolbar_category);

        if(indice_categoria == R.id.categoria_1) {
            toolbar.setTitle("Sinais e Sintomas na Gestação");
        }else if(indice_categoria == R.id.categoria_2) {
            toolbar.setTitle("Acompanhamento Pré-Natal");
        }else if(indice_categoria == R.id.categoria_3) {
            toolbar.setTitle("Perigos à Saúde da Gestante");
        } else if(indice_categoria == R.id.categoria_4) {
            toolbar.setTitle("Informações Relevantes");
        }

        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().show();




    }


    private void setUpNavDrawer(){

        if(toolbar != null){


            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
         //   toolbar.setNavigationIcon(R.drawable.ic_drawer);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent main = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(main);
                }
            });

        }

    }

}
