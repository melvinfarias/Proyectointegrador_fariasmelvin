import { Component, OnInit } from '@angular/core';
import { Experiencia } from 'src/app/model/experiencia';
import { ExpServiceService } from 'src/app/service/exp-service.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-experiencia',
  templateUrl: './experiencia.component.html',
  styleUrls: ['./experiencia.component.css']
})
export class ExperienciaComponent implements OnInit {
expe: Experiencia[] = [];

  constructor(private expService: ExpServiceService, private tokenService : TokenService) { }

  isLogged = false;

  ngOnInit(): void {
  this.cargarExperiencia();
    if(this.tokenService.getToken()){
      this.isLogged = true;
    }else{
      this.isLogged = false;
    }
  }
  cargarExperiencia(): void{
    this.expService.lista().subscribe(data => {this.expe = data;})
    

}


}
