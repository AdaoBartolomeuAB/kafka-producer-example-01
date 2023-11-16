package com.example.kafkaExemplae;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class KafkaController {

    private final MessageProducer messageProducer;

    @PostMapping("/send")
    public DataResquetDTO sendMessage(@RequestParam("message") String message) {
        Map<String,Object> map = new HashMap<>();
        map.put("date", LocalDateTime.now().toString());
        map.put("titulo","Avaliação dos serviços");
        map.put("descricao","Avalie os nossos serviços e diz-nos o que pensa");
        Map<String,Object> tela = new HashMap<>();
        tela.put("tela","TELA_AVALICACO");
        map.put("metaData",tela);
        DataResquetDTO dataResquetDTO = DataResquetDTO.builder().type("ATUALIZA").data(map).build();
        messageProducer.sendMessage("my-topic", dataResquetDTO);
        return dataResquetDTO;
    }
}
