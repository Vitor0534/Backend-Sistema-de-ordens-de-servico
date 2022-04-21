package com.vitor.sistema_ordens_servico;

import com.vitor.sistema_ordens_servico.domain.Cliente;
import com.vitor.sistema_ordens_servico.domain.OrdemDeServico;
import com.vitor.sistema_ordens_servico.domain.Tecnico;
import com.vitor.sistema_ordens_servico.domain.enuns.Prioridade;
import com.vitor.sistema_ordens_servico.domain.enuns.Status;
import com.vitor.sistema_ordens_servico.repositories.ClienteRepository;
import com.vitor.sistema_ordens_servico.repositories.OrdemDeServicoRepository;
import com.vitor.sistema_ordens_servico.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class SistemaOrdensServicoApplication implements CommandLineRunner {

    @Autowired
    private TecnicoRepository tecnicoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private OrdemDeServicoRepository ordemDeServicoRepository;

    public static void main(String[] args) {
        SpringApplication.run(SistemaOrdensServicoApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception{

        Tecnico tec1 = new Tecnico(null, "Arnaldo", "722.207.400-72", "(62) 99999999");
        Tecnico tec2 = new Tecnico(null, "Batania", "556.665.370-75", "(62) 99979969");

        Cliente cli1 = new Cliente(null, "Eduardo", "474.164.660-24", "(11) 98989898");
        Cliente cli2 = new Cliente(null, "Rafael", "018.869.760-82", "(11) 98978732");

        OrdemDeServico ordem_1 = new OrdemDeServico(null, Prioridade.ALTA,"Testando bd", Status.ABERTO, tec1,cli1);
        OrdemDeServico ordem_2 = new OrdemDeServico(null, Prioridade.BAIXA,"Testando bd ordem 2", Status.ANDAMENTO, tec2,cli2);

        tec1.getListaDeOrdensDeServico().add(ordem_1);
        cli1.getListaDeOrdensDeServico().add(ordem_1);

        tec2.getListaDeOrdensDeServico().add(ordem_2);
        cli2.getListaDeOrdensDeServico().add(ordem_2);


        this.tecnicoRepository.saveAll(Arrays.asList(tec1,tec2));
        this.clienteRepository.saveAll(Arrays.asList(cli1,cli2));
        this.ordemDeServicoRepository.saveAll(Arrays.asList(ordem_1,ordem_2));

    }

}
