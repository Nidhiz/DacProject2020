import { Component, OnInit } from '@angular/core';
import * as $ from 'jquery';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor() { }

  ngOnInit(): void 
  {
          $(document).ready(function(){
            setTimeout(function(){
                $('#popUpMain').css('display','block');},5000);
        });

        $('.btn').click(function(){
            $('#popUpMain').css('display','none');

        });
  }

}
